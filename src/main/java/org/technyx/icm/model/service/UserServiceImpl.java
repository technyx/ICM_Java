package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.*;
import org.technyx.icm.model.entity.Address;
import org.technyx.icm.model.entity.ExtraInfo;
import org.technyx.icm.model.entity.User;
import org.technyx.icm.model.repository.UserRepository;
import org.technyx.icm.model.service.interfaces.AddressService;
import org.technyx.icm.model.service.interfaces.ExtraInfoService;
import org.technyx.icm.model.service.interfaces.UserService;
import org.technyx.icm.model.service.validation.interfaces.ExtraInfoValidation;
import org.technyx.icm.model.service.validation.interfaces.UserValidation;
import org.technyx.icm.model.util.ModelMapperConfig;
import org.technyx.icm.model.util.security.ProjectSecurityConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    @Lazy
    private final ExtraInfoService extraInfoService;

    @Lazy
    private final AddressService addressService;

    private final UserValidation validation;

    private final ExtraInfoValidation extraInfoValidation;

    public UserServiceImpl(AddressService addressService, ExtraInfoService extraInfoService, UserRepository repository, UserValidation validation, ExtraInfoValidation extraInfoValidation) {
        this.addressService = addressService;
        this.extraInfoService = extraInfoService;
        this.repository = repository;
        this.validation = validation;
        this.extraInfoValidation = extraInfoValidation;
    }

    @Override
    public UserDto update(UserDto dto) {
        validation.validateUpdate(dto);
        dto.setPassword(ProjectSecurityConfig.passwordEncoder().encode(dto.getPassword()));
        User savedUser = repository.save(
                mapper.map(dto, User.class)
        );
        return mapper.map(savedUser, UserDto.class);
    }

    @Override
    public void delete(UserDto dto) {
        validation.validateExists(dto);
        User model = mapper.map(dto, User.class);
        ExtraInfo extraInfo = extraInfoValidation.validateHaveExtraInfo(model);
        if (extraInfo != null) {
            ExtraInfoDto extraInfoDto = mapper.map(extraInfo, ExtraInfoDto.class);
            extraInfoService.delete(extraInfoDto);
        }
        /*todo: delete address after implement address*/
        repository.delete(mapper.map(dto, User.class));
    }

    @Override
    public Optional<UserDto> showSingle(UserDto dto) {
        validation.validateExists(dto);
        return repository.findById(dto.getId())
                .map((element) -> mapper.map(element, UserDto.class));
    }

    @Override
    public List<UserDto> showList() {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> modelList = repository.findAll();
        modelList.forEach(user -> userDtos
                .add(mapper.map(user, UserDto.class)));
        return userDtos;
    }

    @Override
    public UserWithExtraInfoDto saveWithExtraInfo(UserWithExtraInfoDto dto) {
        User model = mapper.map(dto, User.class);
        validation.validateRegister(model);
        model.setPassword(ProjectSecurityConfig.passwordEncoder().encode(dto.getPassword()));
        User savedUser = repository.save(model);
        dto.setUser(savedUser.getId());
        ExtraInfoDto extraInfoDto = mapper.map(dto, ExtraInfoDto.class);
        extraInfoValidation.validateSave(extraInfoDto);
        ExtraInfoDto savedExtraInfo = extraInfoService.save(extraInfoDto);
        UserWithExtraInfoDto newUserWithExtraInfoDto = new UserWithExtraInfoDto();
        newUserWithExtraInfoDto.map2Model(savedUser, mapper.map(savedExtraInfo, ExtraInfo.class));
        return newUserWithExtraInfoDto;
    }

    @Override
    public UserWithFullDataDto saveWithFullData(UserWithFullDataDto dto) {
        /*todo: need change after implement address*/
        dto.setPassword(ProjectSecurityConfig.passwordEncoder().encode(dto.getPassword()));
        User savedUser = repository.save(mapper.map(dto, User.class));
        dto.setUser(savedUser.getId());
        AddressDto savedAddress = addressService.save(mapper.map(dto, AddressDto.class));
        dto.setAddressId(savedAddress.getId());
        ExtraInfoDto savedExtraInfo = extraInfoService.save(mapper.map(dto, ExtraInfoDto.class));
        UserWithFullDataDto newUserWithFullData = new UserWithFullDataDto();
        newUserWithFullData.map2Model(
                savedUser
                , mapper.map(savedExtraInfo, ExtraInfo.class)
                , mapper.map(savedAddress, Address.class)
        );
        return newUserWithFullData;
    }
}

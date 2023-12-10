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
    public UserDto update(long id, UserDto dto) {
        dto.setId(id);
        validation.validateUpdate(dto);
        dto.setPassword(ProjectSecurityConfig.passwordEncoder().encode(dto.getPassword()));
        User savedUser = repository.save(
                mapper.map(dto, User.class)
        );
        return mapper.map(savedUser, UserDto.class);
    }

    @Override
    public void delete(long id) {
        validation.validateExists(id);
        ExtraInfo extraInfo = extraInfoValidation.validateHaveExtraInfo(id);
        if (extraInfo != null) {
            extraInfoService.delete(extraInfo.getId());
        }
        /*todo: delete address after implement address*/
        repository.deleteById(id);
    }

    @Override
    public Optional<UserDto> showSingle(long id) {
        validation.validateExists(id);
        return repository.findById(id)
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
        dto.setPassword(ProjectSecurityConfig.passwordEncoder().encode(dto.getPassword()));
        User savedUser = repository.save(mapper.map(dto, User.class));
        dto.setUser(savedUser.getId());
        AddressDto savedAddress = addressService.save(mapper.map(dto, AddressDto.class));
        dto.setAddress(savedAddress.getId());
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

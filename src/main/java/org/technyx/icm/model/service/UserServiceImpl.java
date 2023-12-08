package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.*;
import org.technyx.icm.model.entity.Address;
import org.technyx.icm.model.entity.ExtraInfo;
import org.technyx.icm.model.entity.User;
import org.technyx.icm.model.repository.UserRepository;
import org.technyx.icm.model.service.interfaces.AddressService;
import org.technyx.icm.model.service.interfaces.ExtraInfoService;
import org.technyx.icm.model.service.interfaces.UserService;
import org.technyx.icm.model.util.ModelMapperConfig;
import org.technyx.icm.model.util.security.ProjectSecurityConfig;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    @Autowired
    @Lazy
    private ExtraInfoService extraInfoService;

    @Autowired
    @Lazy
    private AddressService addressService;

    @Override
    public UserDto update(UserDto dto) {
        dto.setPassword(ProjectSecurityConfig.passwordEncoder().encode(dto.getPassword()));
        User savedUser = repository.save(
                mapper.map(dto, User.class)
        );
        return mapper.map(savedUser, UserDto.class);
    }

    @Override
    public void delete(UserDto dto) {
        repository.delete(mapper.map(dto, User.class));
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
        dto.setPassword(ProjectSecurityConfig.passwordEncoder().encode(dto.getPassword()));
        User savedUser = repository.save(mapper.map(dto, User.class));
        dto.setUser(savedUser.getId());
        ExtraInfoDto savedExtraInfo = extraInfoService.save(mapper.map(dto, ExtraInfoDto.class));
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

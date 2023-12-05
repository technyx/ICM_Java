package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.ExtraInfoDto;
import org.technyx.icm.model.dtos.FullUserDto;
import org.technyx.icm.model.dtos.UserDto;
import org.technyx.icm.model.entity.ExtraInfo;
import org.technyx.icm.model.entity.User;
import org.technyx.icm.model.repository.UserRepository;
import org.technyx.icm.model.service.interfaces.ExtraInfoService;
import org.technyx.icm.model.service.interfaces.UserService;
import org.technyx.icm.model.util.ModelMapperConfig;
import org.technyx.icm.model.util.security.ProjectSecurityConfig;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    @Override
    public UserDto update(UserDto dto) {
        Long oldModelId = repository.findIdByUsername(dto.getUsername());
        User newModel = mapper.map(dto, User.class);
        newModel.setId(oldModelId);
        User savedUser = repository.save(newModel);
        return mapper.map(savedUser, UserDto.class);
    }

    @Override
    public void delete(UserDto dto) {
        repository.deleteByUsername(dto.getUsername());
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
    public boolean existsById(long id) {
        return repository.existsUserById(id);
    }

    @Override
    public FullUserDto saveWithExtraInfo(FullUserDto dto) {
        dto.setPassword(ProjectSecurityConfig.passwordEncoder().encode(dto.getPassword()));
        User savedUser = repository.save(mapper.map(dto, User.class));
        dto.setUser(savedUser.getId());
        ExtraInfoDto savedExtraInfo = extraInfoService.save(mapper.map(dto, ExtraInfoDto.class));
        FullUserDto newFullUserDto = new FullUserDto();
        newFullUserDto.map2Model(savedUser, mapper.map(savedExtraInfo, ExtraInfo.class));
        return newFullUserDto;
    }
}

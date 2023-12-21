package org.technyx.icm.model.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.technyx.icm.model.dtos.*;
import org.technyx.icm.model.entity.User;
import org.technyx.icm.model.repository.UserRepository;
import org.technyx.icm.model.service.interfaces.UserService;
import org.technyx.icm.model.service.validation.interfaces.UserValidation;
import org.technyx.icm.model.util.ModelMapperConfig;
import org.technyx.icm.model.util.security.ProjectSecurityConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class  UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    private final UserValidation validation;

    public UserServiceImpl(UserRepository repository, UserValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public UserDto update(long id, UserDto dto) {
        dto.setId(id);
        User model = mapper.map(dto, User.class);
        validation.validateUpdate(model);
        dto.setPassword(ProjectSecurityConfig.passwordEncoder().encode(dto.getPassword()));
        User savedUser = repository.save(model);
        return mapper.map(savedUser, UserDto.class);
    }

    @Override
    public void delete(long id) {
        validation.validateExists(id);
        repository.deleteById(id);
    }

    @Override
    public Optional<UserDto> showSingle(long id) {
        validation.validateExists(id);
        return repository.findById(id).map((element) -> mapper.map(element, UserDto.class));
    }

    @Override
    public List<UserDto> showList() {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> modelList = repository.findAllOrderDesc();
        modelList.forEach(user -> userDtos.add(mapper.map(user, UserDto.class)));
        return userDtos;
    }
}

package org.technyx.icm.model.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.technyx.icm.model.dtos.LoginDto;
import org.technyx.icm.model.dtos.RegisterDto;
import org.technyx.icm.model.entity.User;
import org.technyx.icm.model.repository.UserRepository;
import org.technyx.icm.model.service.interfaces.AuthenticateService;
import org.technyx.icm.model.service.validation.interfaces.UserValidation;
import org.technyx.icm.model.util.ModelMapperConfig;
import org.technyx.icm.model.util.security.ProjectSecurityConfig;

@Service
@Transactional
public class AuthenticateServiceImpl implements AuthenticateService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    private final UserRepository repository;

    private final UserValidation validation;

    public AuthenticateServiceImpl(UserRepository repository, UserValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public RegisterDto register(RegisterDto dto) {
        User model = mapper.map(dto, User.class);
        validation.validateRegister(model);
        model.setPassword(ProjectSecurityConfig.passwordEncoder().encode(model.getPassword()));
        User savedModel = repository.save(model);
        return mapper.map(savedModel, RegisterDto.class);
    }

    public LoginDto login(LoginDto dto) {
        User model = mapper.map(dto, User.class);
        User loginModel = repository.findByUsername(model.getUsername());
        validation.validateLogin(model, loginModel);
        return mapper.map(loginModel, LoginDto.class);
    }
}

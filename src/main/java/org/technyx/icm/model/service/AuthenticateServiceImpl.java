package org.technyx.icm.model.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.technyx.icm.model.dtos.LoginDto;
import org.technyx.icm.model.dtos.RegisterDto;
import org.technyx.icm.model.entity.User;
import org.technyx.icm.model.entity.enums.Role;
import org.technyx.icm.model.repository.UserRepository;
import org.technyx.icm.model.service.interfaces.AuthenticateService;
import org.technyx.icm.model.util.ModelMapperConfig;
import org.technyx.icm.model.util.exception.UserExceptionMessages;
import org.technyx.icm.model.util.exception.base.UserException;
import org.technyx.icm.model.util.security.ProjectSecurityConfig;

import java.util.EnumSet;

@Service
@Transactional
public class AuthenticateServiceImpl implements AuthenticateService {

    private final ModelMapper mapper = ModelMapperConfig.getMapperInstance();

    @Autowired
    private UserRepository repository;

    @Override
    public RegisterDto register(RegisterDto dto) {
        User model = mapper.map(dto, User.class);
        validateRegister(model);
        model.setPassword(ProjectSecurityConfig.passwordEncoder().encode(model.getPassword()));
        User savedModel = repository.save(model);
        return mapper.map(savedModel, RegisterDto.class);
    }

    private void validateUsernamePassword(User model) {
        if (model.getUsername().matches("^(?!null$)(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{6,20}$"))
            throw new UserException(UserExceptionMessages.USER_USERNAME_NOT_VALID.getErrorMessage());
        if (!model.getPassword().matches("^(?!null$)(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8}$"))
            throw new UserException(UserExceptionMessages.USER_PASSWORD_NOT_VALID.getErrorMessage());
    }

    private void validateRegister(User model) {
        validateUsernamePassword(model);
        EnumSet<Role> roleEnumSet = EnumSet.allOf(Role.class);
        if (!roleEnumSet.contains(model.getRole()))
            throw new UserException(UserExceptionMessages.USER_ROLE_NOT_VALID.getErrorMessage());
    }

    public LoginDto login(LoginDto dto) {
        User model = mapper.map(dto, User.class);
        User loginModel = repository.findByUsername(model.getUsername());
        validateLogin(model, loginModel);
        return mapper.map(loginModel, LoginDto.class);
    }

    private void validateLogin(User model, User loginModel) {
        validateUsernamePassword(model);
        if (loginModel == null ||
                !ProjectSecurityConfig
                        .passwordEncoder()
                        .matches(model.getPassword(), loginModel.getPassword())) {
            throw new UserException(UserExceptionMessages.USER_NOT_FOUND.getErrorMessage());
        }
    }
}

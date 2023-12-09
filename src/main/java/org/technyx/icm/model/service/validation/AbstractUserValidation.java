package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.entity.User;
import org.technyx.icm.model.entity.enums.Role;
import org.technyx.icm.model.util.exception.UserExceptionMessages;
import org.technyx.icm.model.util.exception.base.UserException;
import org.technyx.icm.model.util.security.ProjectSecurityConfig;

import java.util.EnumSet;

@Component
public abstract class AbstractUserValidation {
    public void validateUsernamePassword(User model) {
        if (!model.getUsername().matches("^(?!null$)(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{6,20}$"))
            throw new UserException(UserExceptionMessages.USER_USERNAME_NOT_VALID.getExceptionMessage());
        if (!model.getPassword().matches("^(?!null$)(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8}$"))
            throw new UserException(UserExceptionMessages.USER_PASSWORD_NOT_VALID.getExceptionMessage());
    }

    public void validateRegister(User model) {
        validateUsernamePassword(model);
        EnumSet<Role> roleEnumSet = EnumSet.allOf(Role.class);
        if (!roleEnumSet.contains(model.getRole()))
            throw new UserException(UserExceptionMessages.USER_ROLE_NOT_VALID.getExceptionMessage());
    }

    public void validateLogin(User model, User loginModel) {
        validateUsernamePassword(model);
        if (loginModel == null ||
                !ProjectSecurityConfig
                        .passwordEncoder()
                        .matches(model.getPassword(), loginModel.getPassword())) {
            throw new UserException(UserExceptionMessages.USER_NOT_FOUND.getExceptionMessage());
        }
    }
}

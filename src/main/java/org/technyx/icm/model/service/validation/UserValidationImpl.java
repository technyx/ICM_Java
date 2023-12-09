package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.entity.User;
import org.technyx.icm.model.entity.enums.Role;
import org.technyx.icm.model.service.validation.interfaces.UserValidation;
import org.technyx.icm.model.util.RegexUtility;
import org.technyx.icm.model.util.exception.UserExceptionMessages;
import org.technyx.icm.model.util.exception.base.UserException;
import org.technyx.icm.model.util.security.ProjectSecurityConfig;

import java.util.EnumSet;

@Component
public class UserValidationImpl implements UserValidation {

    @Override
    public void validateUsernamePassword(User model) {
        if (!model.getUsername().matches(RegexUtility.CHECK_NOT_NULL_CHAR_NUMBER_6_30))
            throw new UserException(UserExceptionMessages.USER_USERNAME_NOT_VALID.getExceptionMessage());
        if (!model.getPassword().matches(RegexUtility.CHECK_NOT_NULL_CONTAIN_ENG_CHAR_AND_NUMBER_MIN_8))
            throw new UserException(UserExceptionMessages.USER_PASSWORD_NOT_VALID.getExceptionMessage());
    }

    @Override
    public void validateRegister(User model) {
        validateUsernamePassword(model);
        EnumSet<Role> roleEnumSet = EnumSet.allOf(Role.class);
        if (!roleEnumSet.contains(model.getRole()))
            throw new UserException(UserExceptionMessages.USER_ROLE_NOT_VALID.getExceptionMessage());
        if (!model.getNationalCode().matches(RegexUtility.CHECK_ONLY_TEN_DIGIT))
            throw new UserException(UserExceptionMessages.NATIONAL_CODE_NOT_VALID.getExceptionMessage());
    }

    @Override
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

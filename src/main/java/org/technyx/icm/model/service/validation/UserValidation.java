package org.technyx.icm.model.service.validation;

import org.technyx.icm.model.entity.User;

public interface UserValidation {

    void validateUsernamePassword(User model);

    void validateRegister(User model);

    void validateLogin(User model, User loginModel);
}

package org.technyx.icm.model.service.validation.interfaces;

import org.technyx.icm.model.entity.User;

public interface UserValidation {

    void validateUsernamePassword(User model);

    void validateRegister(User model);

    void validateLogin(User model, User loginModel);

    void validateUpdate(User model);

    void validateExists(long id);
}

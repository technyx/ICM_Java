package org.technyx.icm.model.service.validation.interfaces;

import org.technyx.icm.model.dtos.ExtraInfoDto;
import org.technyx.icm.model.dtos.UserDto;
import org.technyx.icm.model.entity.User;

public interface UserValidation {

    void validateUsernamePassword(User model);

    void validateRegister(User model);

    void validateLogin(User model, User loginModel);

    void validateUpdate(UserDto dto);

    void validateExists(UserDto dto);
}

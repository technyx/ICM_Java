package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.LoginDto;
import org.technyx.icm.model.dtos.UserDto;

public interface AuthenticateService {

    UserDto register(UserDto dto);

    LoginDto login(LoginDto dto);
}


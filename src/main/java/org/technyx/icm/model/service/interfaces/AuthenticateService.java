package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.LoginDto;
import org.technyx.icm.model.dtos.RegisterDto;
import org.technyx.icm.model.dtos.UserDto;

public interface AuthenticateService {

    RegisterDto register(RegisterDto dto);

    LoginDto login(LoginDto dto);
}


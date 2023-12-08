package org.technyx.icm.model.service.interfaces;

import org.springframework.stereotype.Repository;
import org.technyx.icm.model.dtos.LoginDto;
import org.technyx.icm.model.dtos.RegisterDto;

public interface AuthenticateService {

    RegisterDto register(RegisterDto dto);

    LoginDto login(LoginDto dto);
}


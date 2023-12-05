package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.UserWithExtraInfoDto;
import org.technyx.icm.model.dtos.UserDto;
import org.technyx.icm.model.dtos.UserWithFullDataDto;

import java.util.List;

public interface UserService {

    UserDto update(UserDto dto);

    void delete(UserDto dto);

    List<UserDto> showList();

    UserWithExtraInfoDto saveWithExtraInfo(UserWithExtraInfoDto dto);

    UserWithFullDataDto saveWithFullData(UserWithFullDataDto dto);
}

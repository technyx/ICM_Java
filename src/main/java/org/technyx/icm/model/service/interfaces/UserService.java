package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.FullUserDto;
import org.technyx.icm.model.dtos.UserDto;

import java.util.List;

public interface UserService {

    UserDto update(UserDto dto);

    void delete(UserDto dto);

    List<UserDto> showList();

    boolean existsById(long id);

    FullUserDto saveWithExtraInfo(FullUserDto dto);
}

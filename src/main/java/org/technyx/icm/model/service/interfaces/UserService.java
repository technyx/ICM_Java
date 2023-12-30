package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.UserDto;
import org.technyx.icm.model.dtos.UserUpdateDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto update(long id, UserUpdateDto dto);

    void delete(long id);

    Optional<UserDto> showSingle(long id);

    List<UserDto> showList();
}

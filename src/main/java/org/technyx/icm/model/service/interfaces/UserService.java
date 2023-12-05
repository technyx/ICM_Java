package org.technyx.icm.model.service.interfaces;

import org.technyx.icm.model.dtos.FullUserDto;
import org.technyx.icm.model.entity.User;

public interface UserService {

    boolean existsById(long id);

    FullUserDto fullSave(FullUserDto dto);
}

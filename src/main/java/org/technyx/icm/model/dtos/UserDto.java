package org.technyx.icm.model.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.technyx.icm.model.entity.enums.Role;

@Getter
@Setter
public class UserDto {
    private long id;

    private String username;

    private String password;

    private Role role;
}

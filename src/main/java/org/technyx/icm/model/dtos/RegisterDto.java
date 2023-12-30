package org.technyx.icm.model.dtos;

import lombok.Getter;
import lombok.Setter;
import org.technyx.icm.model.entity.ExtraInfo;
import org.technyx.icm.model.entity.enums.Role;

@Getter
@Setter
public class RegisterDto {

    private long id;

    private String username;

    private String password;

    private String nationalCode;

    private Role role;

    private ExtraInfo extraInfo;
}

package org.technyx.icm.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.technyx.icm.model.entity.enums.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "User")
@Table(name = "tb_user")
public class User extends BaseObject {

    @Column(name = "c_username"
            , unique = true
            , nullable = false)
    private String username;

    @Column(name = "c_password"
            , unique = true
            , nullable = false)
    private String password;

    @Column(name = "c_national_code"
            , unique = true
            , nullable = false)
    private String nationalCode;

    @Column(name = "c_role"
            , nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "c_enabled")
    private boolean enabled = true;
}

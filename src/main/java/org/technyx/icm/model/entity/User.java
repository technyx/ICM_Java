package org.technyx.icm.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.modelmapper.internal.bytebuddy.utility.nullability.NeverNull;
import org.technyx.icm.model.entity.enums.Role;

@Getter
@Setter
@SuperBuilder
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

    @Column(name = "c_role"
    , nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "c_enabled")
    private boolean enabled = true;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

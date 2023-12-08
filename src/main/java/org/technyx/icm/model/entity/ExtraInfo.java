package org.technyx.icm.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ExtraInfo")
@Table(name = "tb_extra_info")
public class ExtraInfo extends BaseObject {

    @Column(name = "fk_user")
    private long user;

    @Column(name = "c_firstname")
    private String firstname;

    @Column(name = "c_lastname")
    private String lastname;

    @Column(name = "c_birth_date")
    private Date birthDate;

    @Column(name = "c_phone")
    private String phone;

    @Column(name = "fk_address")
    private long address;
}

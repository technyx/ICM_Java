package org.technyx.icm.model.dtos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class ExtraInfoDto {

    private long id;

    private long user;

    private String firstname;

    private String lastname;

    private Date birthDate;

    private String phone;
}

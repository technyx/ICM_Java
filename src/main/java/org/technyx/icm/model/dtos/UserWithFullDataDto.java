package org.technyx.icm.model.dtos;

import lombok.Getter;
import lombok.Setter;
import org.technyx.icm.model.entity.Address;
import org.technyx.icm.model.entity.ExtraInfo;
import org.technyx.icm.model.entity.User;
import org.technyx.icm.model.entity.enums.City;
import org.technyx.icm.model.entity.enums.Country;
import org.technyx.icm.model.entity.enums.Role;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
public class UserWithFullDataDto {
    private long id;

    private String username;

    private String password;

    private String nationalCode;

    private Role role;

    private long user;

    private String firstname;

    private String lastname;

    private Date birthDate;

    private String phone;

    private Long address;

    private City city;

    private String location;

    private String postalCode;

    public void map2Model(User user, ExtraInfo extraInfo, Address address) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.nationalCode = user.getNationalCode();
        this.role = user.getRole();
        this.user = extraInfo.getUser();
        this.firstname = extraInfo.getFirstname();
        this.lastname = extraInfo.getLastname();
        this.birthDate = extraInfo.getBirthDate();
        this.phone = extraInfo.getPhone();
        this.address = extraInfo.getAddress();
        this.city = address.getCity();
        this.location = address.getLocation();
        this.postalCode = address.getPostalCode();
    }
}

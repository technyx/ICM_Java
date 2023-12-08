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

    private Role role;

    private Timestamp registerDate;

    private Date birthDate;

    private long user;

    private String firstname;

    private String lastname;

    private String phone;

    private long addressId;

    private Country country;

    private City city;

    private String postalCode;

    private String address;

    public void map2Model(User user, ExtraInfo extraInfo, Address address) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.user = extraInfo.getUser();
        this.firstname = extraInfo.getFirstname();
        this.lastname = extraInfo.getLastname();
        this.birthDate = extraInfo.getBirthDate();
        this.phone = extraInfo.getPhone();
        this.addressId = extraInfo.getAddress();
        this.city = address.getCity();
        this.address = address.getAddress();
        this.postalCode = address.getPostalCode();
    }
}

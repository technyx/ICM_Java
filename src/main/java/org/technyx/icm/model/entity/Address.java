package org.technyx.icm.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.technyx.icm.model.entity.enums.City;
import org.technyx.icm.model.entity.enums.Country;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Address")
@Table(name = "tb_address")
public class Address extends BaseObject{

    @Column(name = "fk_extra_info")
    private long extraInfo;

    @Column(name = "c_country")
    @Enumerated(EnumType.STRING)
    private Country country;

    @Column(name = "c_city")
    @Enumerated(EnumType.STRING)
    private City city;

    @Column(name = "c_address")
    private String address;

    @Column(name = "c_postal_code")
    private String postalCode;
}

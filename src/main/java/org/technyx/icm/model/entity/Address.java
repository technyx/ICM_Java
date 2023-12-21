package org.technyx.icm.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Address")
@Table(name = "tb_address")
public class Address extends BaseObject{

    @Column(name = "c_city")
    private String city;

    @Column(name = "c_location"
            , columnDefinition = "TEXT")
    private String location;

    @Column(name = "c_postal_code")
    private String postalCode;
}

package org.technyx.icm.model.dtos;

import lombok.Getter;
import lombok.Setter;
import org.technyx.icm.model.entity.enums.City;
import org.technyx.icm.model.entity.enums.Country;

@Getter
@Setter
public class AddressDto {

    private long extraInfo;

    private Country country;

    private City city;

    private String address;

    private String postalCode;
}

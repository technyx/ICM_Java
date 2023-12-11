package org.technyx.icm.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    private long id;

    private String city;

    private String location;

    private String postalCode;
}

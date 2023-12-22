package org.technyx.icm.model.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PartnerDto {

    private long id;

    private String discriminator;

    private String title;

    private String coverUrl;
}

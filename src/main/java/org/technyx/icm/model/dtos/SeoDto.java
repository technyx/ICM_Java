package org.technyx.icm.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeoDto {

    private long id;

    private String title;

    private String metaKeyword;

    private String metaDescription;

    private String description;
}

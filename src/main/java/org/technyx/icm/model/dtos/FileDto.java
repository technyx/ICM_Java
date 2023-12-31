package org.technyx.icm.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileDto {

    private long id;

    private String discriminator;

    private String url;

    private int priority;
}

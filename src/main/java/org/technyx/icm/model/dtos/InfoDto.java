package org.technyx.icm.model.dtos;

import lombok.Getter;
import lombok.Setter;
import org.technyx.icm.model.entity.File;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class InfoDto {

    private long id;

    private String title;

    private String text;

    private String discriminator;

    private List<File> files = new ArrayList<>();
}

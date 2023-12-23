package org.technyx.icm.model.dtos;

import lombok.Getter;
import lombok.Setter;
import org.technyx.icm.model.entity.File;

import java.sql.Timestamp;

@Getter
@Setter
public class GalleryDto {

    private long id;

    private String title;

    private File file;

    private Timestamp registerDate;

    private boolean active;
}

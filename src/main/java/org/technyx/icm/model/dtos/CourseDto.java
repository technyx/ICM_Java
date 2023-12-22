package org.technyx.icm.model.dtos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CourseDto {

    private long id;

    private String discriminator;

    private String title;

    private String description;

    private boolean important;

    private String metaKeyword;

    private String metaDescription;

    private Timestamp registerDate;

    private String coverUrl;
}

package org.technyx.icm.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
    private long categoryId;

    private String title;

    private long parent;

}

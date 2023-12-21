package org.technyx.icm.model.dtos;

import lombok.Getter;
import lombok.Setter;
import org.technyx.icm.model.entity.ContentFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PartnerDto {

    private long id;

    private String discriminator;

    private String title;

    private String description;

    private boolean important;

    private String metaKeyword;

    private String metaDescription;

    private List<ContentFile> contentFiles = new ArrayList<>();
}

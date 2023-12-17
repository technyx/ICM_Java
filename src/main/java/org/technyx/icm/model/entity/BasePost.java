package org.technyx.icm.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BasePost extends BaseObject {

    @Column(name = "fk_discriminator")
    private String discriminator;

    @Column(name = "c_title")
    private String title;

    @Column(name = "c_meta_keyword")
    private String metaKeyword;

    @Column(name = "c_meta_description")
    private String metaDescription;
}

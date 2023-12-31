package org.technyx.icm.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseContent extends BaseObject {

    @Column(name = "c_title")
    private String title;

    @Column(name = "c_description"
            , columnDefinition = "TEXT")
    private String description;

    @Column(name = "c_meta_keyword"
            , columnDefinition = "TEXT")
    private String metaKeyword;

    @Column(name = "c_meta_description"
            , columnDefinition = "TEXT")
    private String metaDescription;

    @Column(name = "c_active")
    @ColumnDefault("true")
    private boolean active;

    @Column(name = "c_slug")
    private String slug;
}

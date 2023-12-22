package org.technyx.icm.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Content")
@Table(name = "tb_content")
public class Content extends BaseContent {

    @Column(name = "fk_discriminator")
    private String discriminator;

    @Column(name = "c_description"
            , columnDefinition = "TEXT")
    private String description;

    @Column(name = "c_important")
    private boolean important;

    @Column(name = "c_cover_url")
    private String coverUrl;
}

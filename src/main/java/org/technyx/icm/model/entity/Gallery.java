package org.technyx.icm.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Gallery")
@Table(name = "tb_gallery")
public class Gallery extends BaseObject {

    @Column(name = "c_title")
    private String title;

    @OneToOne(cascade = CascadeType.ALL
            , fetch = FetchType.EAGER
            , orphanRemoval = true)
    @JoinColumn(name = "fk_file"
            , referencedColumnName = "c_id")
    private File file;
}

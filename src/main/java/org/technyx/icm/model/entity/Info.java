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
@Entity(name = "Info")
@Table(name = "tb_info")
public class Info extends BaseObject{

    @Column(name = "c_title")
    private String title;

    @Column(name = "c_text"
            , columnDefinition = "TEXT")
    private String text;

    @Column(name = "c_discriminator")
    private String discriminator;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinTable(name = "m_tb_info_file"
    , joinColumns = @JoinColumn(name = "fk_info")
    , inverseJoinColumns = @JoinColumn(name = "fk_file"))
    private List<File> files;
}

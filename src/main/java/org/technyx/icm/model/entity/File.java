package org.technyx.icm.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "File")
@Table(name = "tb_file")
public class File extends BaseObject {

    @Column(name = "fk_discriminator"
            , nullable = false)
    private String discriminator;

    @Column(name = "c_url"
            , nullable = false)
    private String url;
}

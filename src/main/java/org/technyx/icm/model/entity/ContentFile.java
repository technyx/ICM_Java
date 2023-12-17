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
@Entity(name = "ContentFile")
@Table(name = "tb_content_file")
public class ContentFile extends BaseObject{

    @Column(name = "c_url"
            , nullable = false
            , unique = true)
    private String url;

    @Column(name = "c_priority")
    private int priority;

    @ManyToOne
    @JoinColumn(name = "fk_content")
    private Content content;
}

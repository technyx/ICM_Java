package org.technyx.icm.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_content")
    private Content content;
}

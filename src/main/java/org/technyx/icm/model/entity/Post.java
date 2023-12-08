package org.technyx.icm.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Post")
@Table(name="tb_post")
public class Post extends BaseObject {
    @Column(name="c_title")
    private String title;

    @Column(name="c_description")
    private String description;

    @Column(name="fk_category")
    private long category;

    @Column(name="fk_image")
    private long image;

    @Column(name="fk_cover_image")
    private long cover_image;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }


}

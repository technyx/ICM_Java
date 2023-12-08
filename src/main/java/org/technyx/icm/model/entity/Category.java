package org.technyx.icm.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Category")
@Table(name="tb_category")
public class Category extends BaseObject{

    @Column(name="c_title")
    private String title;

    @Column(name="c_parent")
    private long parent;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }


}

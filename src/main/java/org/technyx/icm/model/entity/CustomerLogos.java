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
@Entity(name = "CustomerLogos")
@Table(name = "tb_customerlogos")
public class CustomerLogos extends BaseObject{

    @Column(name = "c_image_url")
    private String imageUrl;
}

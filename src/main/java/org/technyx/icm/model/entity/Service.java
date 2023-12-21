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
@Entity(name = "Service")
@Table(name = "tb_service")
public class Service extends BaseObject {

    @Column(name = "c_icon"
            , columnDefinition = "TEXT")
    private String icon;

    @Column(name = "c_title")
    private String title;

    @Column(name = "c_description")
    private String description;
}

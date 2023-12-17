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
@Entity(name = "Permission")
@Table(name = "tb_permission")
public class Permission extends BaseObject{

    @Column(name = "c_title")
    private String title;
}

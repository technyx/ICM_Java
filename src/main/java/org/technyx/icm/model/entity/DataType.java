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
@Entity(name = "DataTypes")
@Table(name = "tb_data_type")
public class DataType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "c_id")
    private long id;

    @Column(name = "c_discriminator")
    private String discriminator;

    @Column(name = "c_eng_title")
    private String engTitle;

    @Column(name = "c_per_title")
    private String perTitle;

    @Column(name = "c_priority")
    private long priority;
}

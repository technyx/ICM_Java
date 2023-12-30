package org.technyx.icm.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PaySlip")
@Table(name = "tb_pay_slip")
public class PaySlip extends BaseObject {

    @Column(name = "c_url")
    private String url;

    @Column(name = "c_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "c_id")
    private User user;
}

package org.technyx.icm.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "tb_payslip")
public class PaySlip extends BaseObject {

    @Column(name = "c_url")
    private String url;

    @Column(name = "c_date")
    private Date date;

    @Column(name = "fk_user")
    private long user;
}

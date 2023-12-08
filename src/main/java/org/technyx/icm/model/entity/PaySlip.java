package org.technyx.icm.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Date;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PaySlip")
@Table(name = "tb_payslip")
public class PaySlip extends BaseObject {

    @Column(name = "c_date")
    private Date date;

    @Column(name = "c_url")
    private String url;

    @Column(name = "fk_user_id")
    private long userId;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}

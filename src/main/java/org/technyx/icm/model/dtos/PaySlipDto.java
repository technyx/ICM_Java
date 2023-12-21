package org.technyx.icm.model.dtos;

import lombok.Getter;
import lombok.Setter;
import org.technyx.icm.model.entity.User;

import java.sql.Date;

@Getter
@Setter
public class PaySlipDto {

    private long id;

    private Date date;

    private String url;

    private User user;
}

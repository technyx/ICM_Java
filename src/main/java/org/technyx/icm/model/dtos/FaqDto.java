package org.technyx.icm.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FaqDto {

    private long id;

    private String question;

    private String answer;
}

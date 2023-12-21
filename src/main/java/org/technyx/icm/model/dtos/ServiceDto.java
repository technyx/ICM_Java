package org.technyx.icm.model.dtos;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ServiceDto {

    private long id;

    private String title;

    private String description;

    private Timestamp registerDate;
}

package org.technyx.icm.model.service.validation.interfaces;

import org.technyx.icm.model.dtos.CustomerLogosDto;

public interface CustomerLogosValidation {

    void validateSave(CustomerLogosDto dto);

    void validateUpdate(CustomerLogosDto dto);

    void validateExists(long id);
}

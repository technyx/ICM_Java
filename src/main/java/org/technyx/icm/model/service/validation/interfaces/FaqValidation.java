package org.technyx.icm.model.service.validation.interfaces;

import org.technyx.icm.model.dtos.FaqDto;

public interface FaqValidation {

    void validateSave(FaqDto dto);

    void validateUpdate(FaqDto dto);

    void validateExists(long id);
}

package org.technyx.icm.model.service.validation.interfaces;

import org.technyx.icm.model.dtos.LogoDto;

public interface LogoValidation {

    void validateSave(LogoDto dto);

    void validateUpdate(LogoDto dto);

    void validateExists(long id);
}

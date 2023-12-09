package org.technyx.icm.model.service.validation;

import org.technyx.icm.model.dtos.ExtraInfoDto;

public interface ExtraInfoValidation {

    void validateSave(ExtraInfoDto dto);

    void validateExists(ExtraInfoDto dto);

    void validateUpdate(ExtraInfoDto dto);

    void validateDelete(ExtraInfoDto dto);
}

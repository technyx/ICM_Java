package org.technyx.icm.model.service.validation.interfaces;

import org.technyx.icm.model.dtos.ExtraInfoDto;
import org.technyx.icm.model.entity.ExtraInfo;
import org.technyx.icm.model.entity.User;

public interface ExtraInfoValidation {

    void validateSave(ExtraInfoDto dto);

    void validateExists(long id);

    void validateUpdate(ExtraInfoDto dto);

    ExtraInfo validateHaveExtraInfo(long id);
}

package org.technyx.icm.model.service.validation.interfaces;

import org.technyx.icm.model.dtos.PaySlipDto;

public interface PaySlipValidation {

    void validateSave(PaySlipDto dto);

    void validateUpdate(PaySlipDto dto);

    void validateExists(long id);
}

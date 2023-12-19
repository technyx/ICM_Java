package org.technyx.icm.model.service.validation.interfaces;

import org.technyx.icm.model.dtos.PaySlipDto;
import org.technyx.icm.model.entity.PaySlip;

public interface PaySlipValidation {

    void validateSave(PaySlip model);

    void validateUpdate(PaySlip model);

    void validateExists(long id);
}

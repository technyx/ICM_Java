package org.technyx.icm.model.service.validation.interfaces;

import org.technyx.icm.model.dtos.FaqDto;
import org.technyx.icm.model.entity.Faq;

public interface FaqValidation {

    void validateSave(Faq model);

    void validateUpdate(Faq model);

    void validateExists(long id);
}

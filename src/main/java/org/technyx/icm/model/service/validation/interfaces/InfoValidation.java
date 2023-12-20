package org.technyx.icm.model.service.validation.interfaces;

import org.technyx.icm.model.entity.Info;

public interface InfoValidation {

    void validateBaseInfo(Info model);

    void validateExists(long id);
}

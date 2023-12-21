package org.technyx.icm.model.service.validation.interfaces;

import org.technyx.icm.model.entity.Service;

public interface ServiceValidation {

    void validateBaseInfo(Service model);

    void validateExists(long id);
}

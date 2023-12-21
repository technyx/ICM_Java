package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.entity.Service;
import org.technyx.icm.model.service.validation.interfaces.ServiceValidation;

@Component
public class ServiceValidationImpl implements ServiceValidation {
    @Override
    public void validateBaseInfo(Service model) {

    }

    @Override
    public void validateExists(long id) {

    }
}

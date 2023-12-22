package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.entity.Gallery;
import org.technyx.icm.model.entity.Service;
import org.technyx.icm.model.repository.ServiceRepository;
import org.technyx.icm.model.service.validation.interfaces.ServiceValidation;
import org.technyx.icm.model.util.exception.GalleryExceptionMessage;
import org.technyx.icm.model.util.exception.ServiceExceptionMessage;
import org.technyx.icm.model.util.exception.base.GalleryException;
import org.technyx.icm.model.util.exception.base.ServiceException;

@Component
public class ServiceValidationImpl implements ServiceValidation {

    private final ServiceRepository repository;

    public ServiceValidationImpl(ServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validateBaseInfo(Service model) {
        if (model.getIcon() == null)
            throw new ServiceException(ServiceExceptionMessage.SERVICE_ICON_IS_EMPTY.getExceptionMessage());
        if (model.getTitle().isBlank())
            throw new ServiceException(ServiceExceptionMessage.SERVICE_TITLE_IS_EMPTY.getExceptionMessage());
        if (model.getDescription().isBlank())
            throw new ServiceException(ServiceExceptionMessage.SERVICE_DESCRIPTION_IS_EMPTY.getExceptionMessage());
    }

    @Override
    public void validateExists(long id) {
        if (!repository.existsById(id))
            throw new ServiceException(ServiceExceptionMessage.SERVICE_NOT_FOUND.getExceptionMessage());
    }
}

package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.entity.Gallery;
import org.technyx.icm.model.service.validation.interfaces.GalleryValidation;

@Component
public class GalleryValidationImpl implements GalleryValidation {
    @Override
    public void validateBaseInfo(Gallery model) {

    }

    @Override
    public void validateExists(long id) {

    }
}

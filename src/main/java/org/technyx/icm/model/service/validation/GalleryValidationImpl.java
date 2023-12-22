package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.entity.Gallery;
import org.technyx.icm.model.repository.GalleryRepository;
import org.technyx.icm.model.service.validation.interfaces.GalleryValidation;
import org.technyx.icm.model.util.exception.GalleryExceptionMessage;
import org.technyx.icm.model.util.exception.base.GalleryException;

@Component
public class GalleryValidationImpl implements GalleryValidation {

    private final GalleryRepository repository;

    public GalleryValidationImpl(GalleryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validateBaseInfo(Gallery model) {
        if (model.getTitle().isBlank())
            throw new GalleryException(GalleryExceptionMessage.GALLERY_TITLE_IS_EMPTY.getExceptionMessage());
        if (model.getFile() == null)
            throw new GalleryException(GalleryExceptionMessage.GALLERY_FILE_IS_EMPTY.getExceptionMessage());
    }

    @Override
    public void validateExists(long id) {
        if (!repository.existsById(id))
            throw new GalleryException(GalleryExceptionMessage.GALLERY_NOT_FOUND.getExceptionMessage());
    }
}

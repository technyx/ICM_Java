package org.technyx.icm.model.service.validation.interfaces;

import org.technyx.icm.model.entity.Gallery;

public interface GalleryValidation {

    void validateBaseInfo(Gallery model);

    void validateExists(long id);
}

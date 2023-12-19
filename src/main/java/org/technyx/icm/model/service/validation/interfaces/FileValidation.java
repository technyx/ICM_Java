package org.technyx.icm.model.service.validation.interfaces;

import org.technyx.icm.model.entity.File;

public interface FileValidation {

    void validateSave(File model);

    void validateUpdate(File model);

    void validateExists(long id);
}

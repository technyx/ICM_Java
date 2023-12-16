package org.technyx.icm.model.service.validation.interfaces;

import org.technyx.icm.model.dtos.FileDto;

public interface FileValidation {

    void validateSave(FileDto dto);

    void validateUpdate(FileDto dto);

    void validateExists(long id);
}

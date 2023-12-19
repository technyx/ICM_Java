package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.entity.File;
import org.technyx.icm.model.repository.FileRepository;
import org.technyx.icm.model.service.validation.interfaces.FileValidation;
import org.technyx.icm.model.util.exception.FileExceptionMessage;
import org.technyx.icm.model.util.exception.base.FileException;

@Component
public class FileValidationImpl implements FileValidation {

    private final FileRepository repository;

    public FileValidationImpl(FileRepository repository) {
        this.repository = repository;
    }

    private void validateBaseInfo(File model) {
        if (model.getDiscriminator().isBlank())
            throw new FileException(FileExceptionMessage.DISCRIMINATOR_IS_EMPTY.getExceptionMessage());
        if (model.getUrl().isBlank())
            throw new FileException(FileExceptionMessage.URL_IS_EMPTY.getExceptionMessage());
    }

    @Override
    public void validateSave(File model) {
        validateBaseInfo(model);
    }

    @Override
    public void validateUpdate(File model) {
        validateExists(model.getId());
        validateBaseInfo(model);
    }

    @Override
    public void validateExists(long id) {
        if (repository.existsById(id))
            throw new FileException(FileExceptionMessage.FILE_NOT_FOUND.getExceptionMessage());
    }
}

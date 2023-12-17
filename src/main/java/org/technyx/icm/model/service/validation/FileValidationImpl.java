package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.dtos.FileDto;
import org.technyx.icm.model.repository.DataTypeRepository;
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

    private void validateBaseInfo(FileDto dto) {
        if (dto.getDiscriminator().isEmpty() ||
        dto.getDiscriminator().isBlank())
            throw new FileException(FileExceptionMessage.DISCRIMINATOR_IS_EMPTY.getExceptionMessage());
        if (dto.getUrl().isEmpty() ||
                dto.getUrl().isBlank())
            throw new FileException(FileExceptionMessage.URL_IS_EMPTY.getExceptionMessage());
    }

    @Override
    public void validateSave(FileDto dto) {
        validateBaseInfo(dto);
    }

    @Override
    public void validateUpdate(FileDto dto) {
        validateExists(dto.getId());
        validateBaseInfo(dto);
    }

    @Override
    public void validateExists(long id) {
        if (repository.existsById(id))
            throw new FileException(FileExceptionMessage.FILE_NOT_FOUND.getExceptionMessage());
    }
}

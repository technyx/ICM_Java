package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.dtos.LogoDto;
import org.technyx.icm.model.repository.FileRepository;
import org.technyx.icm.model.service.validation.interfaces.LogoValidation;
import org.technyx.icm.model.util.exception.LogoExceptionMessage;
import org.technyx.icm.model.util.exception.base.LogoException;

@Component
public class LogoValidationImpl implements LogoValidation {

    private final FileRepository repository;

    public LogoValidationImpl(FileRepository repository) {
        this.repository = repository;
    }

    private void validateBaseInfo(LogoDto dto) {
        if (dto.getUrl().isBlank())
            throw new LogoException(LogoExceptionMessage.URL_IS_EMPTY.getExceptionMessage());
    }

    @Override
    public void validateSave(LogoDto dto) {
        validateBaseInfo(dto);
    }

    @Override
    public void validateUpdate(LogoDto dto) {
        validateExists(dto.getId());
        validateBaseInfo(dto);
    }

    @Override
    public void validateExists(long id) {
        if (repository.existsById(id))
            throw new LogoException(LogoExceptionMessage.LOGO_NOT_FOUND.getExceptionMessage());
    }
}

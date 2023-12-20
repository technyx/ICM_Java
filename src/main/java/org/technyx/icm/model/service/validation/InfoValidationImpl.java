package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.entity.Info;
import org.technyx.icm.model.repository.InfoRepository;
import org.technyx.icm.model.service.validation.interfaces.InfoValidation;
import org.technyx.icm.model.util.exception.InfoExceptionMessage;
import org.technyx.icm.model.util.exception.base.InfoException;

@Component
public class InfoValidationImpl implements InfoValidation {

    private final InfoRepository repository;

    public InfoValidationImpl(InfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validateBaseInfo(Info model) {
        if (model.getTitle().length() < 8)
            throw new InfoException(InfoExceptionMessage.INFO_TITLE_MUST_BE_AT_LEAST_8_CHAR.getExceptionMessage());
        if (model.getText().length() < 21)
            throw new InfoException(InfoExceptionMessage.INFO_TEXT_MUST_BE_AT_LEAST_8_CHAR.getExceptionMessage());
        if (model.getFiles().size() < 2)
            throw new InfoException(InfoExceptionMessage.INFO_FILE_MUST_BE_AT_LEAST_2.getExceptionMessage());
        if (model.getDiscriminator().isBlank())
            throw new InfoException(InfoExceptionMessage.INFO_DISCRIMINATOR_IS_BLANK.getExceptionMessage());
    }

    @Override
    public void validateExists(long id) {
        if (!repository.existsById(id))
            throw new InfoException(InfoExceptionMessage.INFO_NOT_FOUND.getExceptionMessage());
    }
}

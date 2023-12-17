package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.dtos.FaqDto;
import org.technyx.icm.model.repository.DataTypeRepository;
import org.technyx.icm.model.repository.FaqRepository;
import org.technyx.icm.model.service.validation.interfaces.FaqValidation;
import org.technyx.icm.model.util.exception.FaqExceptionMessage;
import org.technyx.icm.model.util.exception.base.FaqException;

@Component
public class FaqServiceImpl implements FaqValidation {

    private final FaqRepository repository;

    public FaqServiceImpl(FaqRepository repository) {
        this.repository = repository;
    }

    private void validateBaseInfo(FaqDto dto) {
        if (dto.getQuestion().isEmpty() ||
        dto.getQuestion().isBlank())
            throw new FaqException(FaqExceptionMessage.QUESTION_IS_EMPTY.getExceptionMessage());
        if (dto.getAnswer().isEmpty() ||
        dto.getAnswer().isBlank())
            throw new FaqException(FaqExceptionMessage.ANSWER_IS_EMPTY.getExceptionMessage());
    }

    @Override
    public void validateSave(FaqDto dto) {
        validateBaseInfo(dto);
    }

    @Override
    public void validateUpdate(FaqDto dto) {
        validateExists(dto.getId());
        validateBaseInfo(dto);
    }

    @Override
    public void validateExists(long id) {
        if (!repository.existsById(id))
            throw new FaqException(FaqExceptionMessage.FAQ_NOT_FOUND.getExceptionMessage());
    }
}

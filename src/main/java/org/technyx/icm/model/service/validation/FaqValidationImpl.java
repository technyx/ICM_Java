package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.entity.Faq;
import org.technyx.icm.model.repository.FaqRepository;
import org.technyx.icm.model.service.validation.interfaces.FaqValidation;
import org.technyx.icm.model.util.exception.FaqExceptionMessage;
import org.technyx.icm.model.util.exception.base.FaqException;

@Component
public class FaqValidationImpl implements FaqValidation {

    private final FaqRepository repository;

    public FaqValidationImpl(FaqRepository repository) {
        this.repository = repository;
    }

    private void validateBaseInfo(Faq model) {
//        if (model.getQuestion().isEmpty() ||
//                model.getQuestion().isBlank())
//            throw new FaqException(FaqExceptionMessage.QUESTION_IS_EMPTY.getExceptionMessage());
//        if (model.getAnswer().isEmpty() ||
//                model.getAnswer().isBlank())
//            throw new FaqException(FaqExceptionMessage.ANSWER_IS_EMPTY.getExceptionMessage());
    }

    @Override
    public void validateSave(Faq model) {
        validateBaseInfo(model);
    }

    @Override
    public void validateUpdate(Faq model) {
        validateExists(model.getId());
        validateBaseInfo(model);
    }

    @Override
    public void validateExists(long id) {
        if (!repository.existsById(id))
            throw new FaqException(FaqExceptionMessage.FAQ_NOT_FOUND.getExceptionMessage());
    }
}

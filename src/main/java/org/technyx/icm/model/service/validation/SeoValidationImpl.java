package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.entity.Seo;
import org.technyx.icm.model.repository.SeoRepository;
import org.technyx.icm.model.service.validation.interfaces.SeoValidation;
import org.technyx.icm.model.util.exception.SeoExceptionMessage;
import org.technyx.icm.model.util.exception.base.SeoException;

@Component
public class SeoValidationImpl implements SeoValidation {

    private final SeoRepository repository;

    public SeoValidationImpl(SeoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validateBaseInfo(Seo model) {
        if (model.getTitle().isBlank())
            throw new SeoException(SeoExceptionMessage.SEO_TITLE_IS_EMPTY.getExceptionMessage());
        if (model.getDescription().isBlank())
            throw new SeoException(SeoExceptionMessage.SEO_DESCRIPTION_IS_EMPTY.getExceptionMessage());
    }

    @Override
    public void validateExists(long id) {
        if (!repository.existsById(id))
            throw new SeoException(SeoExceptionMessage.SEO_NOT_FOUND.getExceptionMessage());
    }
}

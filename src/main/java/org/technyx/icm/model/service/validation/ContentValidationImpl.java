package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.entity.Content;
import org.technyx.icm.model.repository.ContentRepository;
import org.technyx.icm.model.service.validation.interfaces.ContentValidation;
import org.technyx.icm.model.util.exception.ContentExceptionMessage;
import org.technyx.icm.model.util.exception.base.ContentException;

@Component
public class ContentValidationImpl implements ContentValidation {

    private final ContentRepository repository;

    public ContentValidationImpl(ContentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validateBaseInfo(Content model) {
        if (model.getTitle().isBlank())
            throw new ContentException(ContentExceptionMessage.TITLE_IS_EMPTY.getExceptionMessage());
        if (model.getDescription().isBlank())
            throw new ContentException(ContentExceptionMessage.DESCRIPTION_IS_EMPTY.getExceptionMessage());
        if (model.getContentFiles().size() <= 1 &&
                model.getContentFiles().get(0).getPriority() != 0)
            throw new ContentException(ContentExceptionMessage.CONTENT_FILE_IS_EMPTY.getExceptionMessage());
    }

    @Override
    public void validateExists(long id) {
        if (!repository.existsById(id))
            throw new ContentException(ContentExceptionMessage.CONTENT_NOT_FOUND.getExceptionMessage());
    }
}

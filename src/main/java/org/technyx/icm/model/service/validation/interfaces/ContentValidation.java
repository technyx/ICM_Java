package org.technyx.icm.model.service.validation.interfaces;

import org.technyx.icm.model.entity.Content;

public interface ContentValidation {
    
    void validateBaseInfo(Content model);

    void validateExists(long id);
}

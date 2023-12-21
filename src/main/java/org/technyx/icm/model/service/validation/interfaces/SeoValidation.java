package org.technyx.icm.model.service.validation.interfaces;

import org.technyx.icm.model.dtos.SeoDto;
import org.technyx.icm.model.entity.Seo;

public interface SeoValidation {

    void validateBaseInfo(Seo model);

    void validateExists(long id);
}

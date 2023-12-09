package org.technyx.icm.model.service.validation.interfaces;

import org.technyx.icm.model.dtos.AddressDto;

public interface AddressValidation {

    void validateSave(AddressDto dto);
}

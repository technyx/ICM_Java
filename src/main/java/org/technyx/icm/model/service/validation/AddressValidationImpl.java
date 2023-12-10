package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.dtos.AddressDto;
import org.technyx.icm.model.entity.enums.City;
import org.technyx.icm.model.entity.enums.Country;
import org.technyx.icm.model.repository.AddressRepository;
import org.technyx.icm.model.repository.ExtraInfoRepository;
import org.technyx.icm.model.service.validation.interfaces.AddressValidation;
import org.technyx.icm.model.util.RegexUtility;
import org.technyx.icm.model.util.exception.AddressExceptionMessage;
import org.technyx.icm.model.util.exception.ExtraInfoExceptionMessage;
import org.technyx.icm.model.util.exception.base.AddressException;
import org.technyx.icm.model.util.exception.base.ExtraInfoException;

import java.util.EnumSet;

@Component
public class AddressValidationImpl implements AddressValidation {

    private final AddressRepository repository;

    public AddressValidationImpl(AddressRepository repository) {
        this.repository = repository;
    }

    private void validateBaseInfo(AddressDto dto) {
        EnumSet<City> cityEnumSet = EnumSet.allOf(City.class);
        if (!cityEnumSet.contains(dto.getCity()))
            throw new AddressException(AddressExceptionMessage.CITY_NOT_VALID.getExceptionMessage());
        if (!dto.getLocation().matches(RegexUtility.PER_LOCATION))
            throw new AddressException(AddressExceptionMessage.LOCATION_NOT_VALID.getExceptionMessage());
        if (dto.getPostalCode() != null)
            if (!dto.getPostalCode().matches(RegexUtility.PER_POSTAL_CODE))
                throw new AddressException(AddressExceptionMessage.POSTAL_CODE_NOT_VALID.getExceptionMessage());
    }

    @Override
    public void validateSave(AddressDto dto) {
        validateBaseInfo(dto);
    }

    @Override
    public void validateUpdate(AddressDto dto) {
        validateExists(dto.getId());
        validateBaseInfo(dto);
    }

    @Override
    public void validateExists(long id) {
        if (repository.existsById(id))
            throw new AddressException(AddressExceptionMessage.ADDRESS_NOT_FOUND.getExceptionMessage());
    }
}

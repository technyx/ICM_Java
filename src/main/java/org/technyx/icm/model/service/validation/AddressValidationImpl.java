package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.dtos.AddressDto;
import org.technyx.icm.model.entity.enums.City;
import org.technyx.icm.model.entity.enums.Country;
import org.technyx.icm.model.repository.ExtraInfoRepository;
import org.technyx.icm.model.service.validation.interfaces.AddressValidation;
import org.technyx.icm.model.util.exception.AddressExceptionMessage;
import org.technyx.icm.model.util.exception.ExtraInfoExceptionMessage;
import org.technyx.icm.model.util.exception.base.AddressException;
import org.technyx.icm.model.util.exception.base.ExtraInfoException;

import java.util.EnumSet;

@Component
public class AddressValidationImpl implements AddressValidation {

    private final ExtraInfoRepository extraInfoRepository;

    public AddressValidationImpl(ExtraInfoRepository extraInfoRepository) {
        this.extraInfoRepository = extraInfoRepository;
    }

    @Override
    public void validateSave(AddressDto dto) {
        if (!extraInfoRepository.existsById(dto.getExtraInfo()))
            throw new ExtraInfoException(ExtraInfoExceptionMessage.EXTRA_INFO_NOT_FOUND.getExceptionMessage());
        EnumSet<Country> countryEnumSet = EnumSet.allOf(Country.class);
        if (!countryEnumSet.contains(dto.getCountry()))
            throw new AddressException(AddressExceptionMessage.COUNTRY_NOT_VALID.getExceptionMessage());
        EnumSet<City> cityEnumSet = EnumSet.allOf(City.class);
        if (!cityEnumSet.contains(dto.getCity()))
            throw new AddressException(AddressExceptionMessage.CITY_NOT_VALID.getExceptionMessage());
        if (!dto.getLocation().matches("^[آابپتثجچحخدذرزژسشصضطظعغفقکگلمنوهیئء0-9]+{10,}$"))
            throw new AddressException(AddressExceptionMessage.LOCATION_NOT_VALID.getExceptionMessage());
        if (dto.getPostalCode() != null)
            if (!dto.getPostalCode().matches("^(\\\\d{5}-\\\\d{4}|\\\\d{10})$"))
                throw new AddressException(AddressExceptionMessage.POSTAL_CODE_NOT_VALID.getExceptionMessage());
    }
}

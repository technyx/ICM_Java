package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.dtos.AddressDto;
import org.technyx.icm.model.entity.DataType;
import org.technyx.icm.model.entity.enums.Discriminator;
import org.technyx.icm.model.repository.AddressRepository;
import org.technyx.icm.model.repository.DataTypeRepository;
import org.technyx.icm.model.service.validation.interfaces.AddressValidation;
import org.technyx.icm.model.util.RegexUtility;
import org.technyx.icm.model.util.exception.AddressExceptionMessage;
import org.technyx.icm.model.util.exception.base.AddressException;

import java.util.EnumSet;
import java.util.List;

@Component
public class AddressValidationImpl implements AddressValidation {

    private final AddressRepository repository;

    private final DataTypeRepository dataTypeRepository;

    public AddressValidationImpl(AddressRepository repository, DataTypeRepository dataTypeRepository) {
        this.repository = repository;
        this.dataTypeRepository = dataTypeRepository;
    }

    private void validateBaseInfo(AddressDto dto) {
        List<DataType> cityTypes = dataTypeRepository.findByDiscriminatorOrderByPriority(Discriminator.CITY_NAME);
        if (cityTypes.stream().noneMatch(dataType -> dataType.getPerTitle().equals(dto.getCity())))
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

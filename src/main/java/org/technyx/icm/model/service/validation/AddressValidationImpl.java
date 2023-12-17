package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.entity.Address;
import org.technyx.icm.model.entity.DataType;
import org.technyx.icm.model.repository.DataTypeRepository;
import org.technyx.icm.model.service.validation.interfaces.AddressValidation;
import org.technyx.icm.model.util.RegexUtility;
import org.technyx.icm.model.util.exception.AddressExceptionMessage;
import org.technyx.icm.model.util.exception.base.AddressException;

import java.util.List;

@Component
public class AddressValidationImpl implements AddressValidation {

    private final DataTypeRepository dataTypeRepository;

    private final static String DISCRIMINATOR = "CITY_NAME";

    public AddressValidationImpl(DataTypeRepository dataTypeRepository) {
        this.dataTypeRepository = dataTypeRepository;
    }

    @Override
    public void validateBaseInfo(Address model) {
        List<DataType> cityTypes = dataTypeRepository.findByDiscriminatorOrderByPriority(DISCRIMINATOR);
        if (cityTypes.stream().noneMatch(dataType -> dataType.getPerTitle().equals(model.getCity())))
            throw new AddressException(AddressExceptionMessage.CITY_NOT_VALID.getExceptionMessage());
        if (!model.getLocation().matches(RegexUtility.PER_LOCATION))
            throw new AddressException(AddressExceptionMessage.LOCATION_NOT_VALID.getExceptionMessage());
        if (model.getPostalCode() != null)
            if (!model.getPostalCode().matches(RegexUtility.PER_POSTAL_CODE))
                throw new AddressException(AddressExceptionMessage.POSTAL_CODE_NOT_VALID.getExceptionMessage());
    }
}

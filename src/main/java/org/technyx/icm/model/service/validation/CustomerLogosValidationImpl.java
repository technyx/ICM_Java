package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.dtos.CustomerLogosDto;
import org.technyx.icm.model.repository.CustomerLogosRepository;
import org.technyx.icm.model.repository.DataTypeRepository;
import org.technyx.icm.model.service.validation.interfaces.CustomerLogosValidation;
import org.technyx.icm.model.util.exception.CustomerLogosExceptionMessage;
import org.technyx.icm.model.util.exception.base.CustomerLogosException;

@Component
public class CustomerLogosValidationImpl implements CustomerLogosValidation {

    private final CustomerLogosRepository repository;

    private final DataTypeRepository dataTypeRepository;

    public CustomerLogosValidationImpl(CustomerLogosRepository repository, DataTypeRepository dataTypeRepository) {
        this.repository = repository;
        this.dataTypeRepository = dataTypeRepository;
    }

    private void validateBaseInfo(CustomerLogosDto dto) {
    }

    @Override
    public void validateSave(CustomerLogosDto dto) {
        validateBaseInfo(dto);
    }

    @Override
    public void validateUpdate(CustomerLogosDto dto) {
        validateExists(dto.getId());
        validateBaseInfo(dto);
    }

    @Override
    public void validateExists(long id) {
        if (repository.existsById(id))
            throw new CustomerLogosException(CustomerLogosExceptionMessage.CUSTOMERLOGO_NOT_FOUND.getExceptionMessage());
    }
}

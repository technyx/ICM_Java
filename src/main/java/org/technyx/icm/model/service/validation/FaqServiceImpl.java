package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.dtos.FaqDto;
import org.technyx.icm.model.repository.DataTypeRepository;
import org.technyx.icm.model.repository.FaqRepository;
import org.technyx.icm.model.service.validation.interfaces.FaqValidation;
import org.technyx.icm.model.util.exception.FaqExceptionMessage;
import org.technyx.icm.model.util.exception.base.FaqException;

@Component
public class FaqServiceImpl implements FaqValidation {

    private final FaqRepository repository;

    private final DataTypeRepository dataTypeRepository;

    public FaqServiceImpl(FaqRepository repository, DataTypeRepository dataTypeRepository) {
        this.repository = repository;
        this.dataTypeRepository = dataTypeRepository;
    }

    private void validateBaseInfo(FaqDto dto) {

    }

    @Override
    public void validateSave(FaqDto dto) {
        validateBaseInfo(dto);
    }

    @Override
    public void validateUpdate(FaqDto dto) {
        validateExists(dto.getId());
        validateBaseInfo(dto);
    }

    @Override
    public void validateExists(long id) {
        if (repository.existsById(id))
            throw new FaqException(FaqExceptionMessage.ANSWER_NOT_FOUND.getExceptionMessage());
    }
}

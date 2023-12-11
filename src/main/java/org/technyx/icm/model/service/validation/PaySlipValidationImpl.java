package org.technyx.icm.model.service.validation;

import jdk.jfr.Category;
import org.springframework.stereotype.Component;
import org.technyx.icm.model.dtos.PaySlipDto;
import org.technyx.icm.model.repository.PaySlipRepository;
import org.technyx.icm.model.repository.UserRepository;
import org.technyx.icm.model.service.validation.interfaces.PaySlipValidation;
import org.technyx.icm.model.util.exception.PaySlipExceptionMessage;
import org.technyx.icm.model.util.exception.UserExceptionMessages;
import org.technyx.icm.model.util.exception.base.PaySlipException;
import org.technyx.icm.model.util.exception.base.UserException;

@Component
public class PaySlipValidationImpl implements PaySlipValidation {

    private final PaySlipRepository repository;

    private final UserRepository userRepository;

    public PaySlipValidationImpl(PaySlipRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    private void validateBaseInfo(PaySlipDto dto) {
        if (!userRepository.existsById(dto.getUser()))
            throw new UserException(UserExceptionMessages.USER_NOT_FOUND.getExceptionMessage());
    }

    @Override
    public void validateSave(PaySlipDto dto) {
        validateBaseInfo(dto);
    }

    @Override
    public void validateUpdate(PaySlipDto dto) {
        validateExists(dto.getId());
        validateBaseInfo(dto);
    }

    @Override
    public void validateExists(long id) {
        if (!repository.existsById(id))
            throw new PaySlipException(PaySlipExceptionMessage.PAY_SLIP_NOT_FOUND.getExceptionMessage());
    }
}

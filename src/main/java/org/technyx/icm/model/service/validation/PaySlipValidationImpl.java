package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.dtos.PaySlipDto;
import org.technyx.icm.model.entity.PaySlip;
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

    private void validateBaseInfo(PaySlip model) {
        if (!userRepository.existsById(model.getUser()))
            throw new UserException(UserExceptionMessages.USER_NOT_FOUND.getExceptionMessage());
    }

    @Override
    public void validateSave(PaySlip model) {
        validateBaseInfo(model);
    }

    @Override
    public void validateUpdate(PaySlip model) {
        validateExists(model.getId());
        validateBaseInfo(model);
    }

    @Override
    public void validateExists(long id) {
        if (!repository.existsById(id))
            throw new PaySlipException(PaySlipExceptionMessage.PAY_SLIP_NOT_FOUND.getExceptionMessage());
    }
}

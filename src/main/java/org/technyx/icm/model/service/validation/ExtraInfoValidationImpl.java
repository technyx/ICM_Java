package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.dtos.ExtraInfoDto;
import org.technyx.icm.model.entity.ExtraInfo;
import org.technyx.icm.model.entity.User;
import org.technyx.icm.model.repository.AddressRepository;
import org.technyx.icm.model.repository.ExtraInfoRepository;
import org.technyx.icm.model.repository.UserRepository;
import org.technyx.icm.model.service.validation.interfaces.ExtraInfoValidation;
import org.technyx.icm.model.util.RegexUtility;
import org.technyx.icm.model.util.exception.AddressExceptionMessage;
import org.technyx.icm.model.util.exception.ExtraInfoExceptionMessage;
import org.technyx.icm.model.util.exception.UserExceptionMessages;
import org.technyx.icm.model.util.exception.base.AddressException;
import org.technyx.icm.model.util.exception.base.ExtraInfoException;
import org.technyx.icm.model.util.exception.base.UserException;

import java.time.LocalDate;
import java.time.Period;

@Component
public class ExtraInfoValidationImpl implements ExtraInfoValidation {

    private final ExtraInfoRepository repository;

    private final UserRepository userRepository;

    public ExtraInfoValidationImpl(UserRepository userRepository, ExtraInfoRepository repository) {
        this.userRepository = userRepository;
        this.repository = repository;
    }

    private void validateBaseInfo(ExtraInfoDto dto) {
        if (!userRepository.existsById(dto.getUser()))
            throw new UserException(UserExceptionMessages.USER_NOT_FOUND.getExceptionMessage());
        if (!dto.getFirstname().matches(RegexUtility.CHECK_ENG_OR_PER_CHAR_2_50))
            throw new ExtraInfoException(ExtraInfoExceptionMessage.FIRSTNAME_IS_NOT_VALID.getExceptionMessage());
        if (!dto.getLastname().matches(RegexUtility.CHECK_ENG_OR_PER_CHAR_2_50))
            throw new ExtraInfoException(ExtraInfoExceptionMessage.LASTNAME_IS_NOT_VALID.getExceptionMessage());
        LocalDate birthDate = dto.getBirthDate().toLocalDate();
        Period period = Period.between(birthDate, LocalDate.now());
        if (period.getYears() <= 18)
            throw new ExtraInfoException(ExtraInfoExceptionMessage.AGE_IS_NOT_VALID.getExceptionMessage());
        if (!dto.getPhone().matches(RegexUtility.CHECK_IRI_PHONE))
            throw new ExtraInfoException(ExtraInfoExceptionMessage.PHONE_IS_NOT_VALID.getExceptionMessage());
    }

    @Override
    public void validateSave(ExtraInfoDto dto) {
        validateBaseInfo(dto);
    }

    @Override
    public void validateExists(long id) {
        if (!repository.existsById(id))
            throw new ExtraInfoException(ExtraInfoExceptionMessage.EXTRA_INFO_NOT_FOUND.getExceptionMessage());
    }

    @Override
    public void validateUpdate(ExtraInfoDto dto) {
        validateExists(dto.getId());
        validateBaseInfo(dto);
    }

    @Override
    public ExtraInfo validateHaveExtraInfo(long id) {
        return repository.findByUser(id);
    }
}

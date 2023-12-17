package org.technyx.icm.model.service.validation;

import org.springframework.stereotype.Component;
import org.technyx.icm.model.entity.ExtraInfo;
import org.technyx.icm.model.service.validation.interfaces.ExtraInfoValidation;
import org.technyx.icm.model.util.RegexUtility;
import org.technyx.icm.model.util.exception.ExtraInfoExceptionMessage;
import org.technyx.icm.model.util.exception.base.ExtraInfoException;

import java.time.LocalDate;
import java.time.Period;

@Component
public class ExtraInfoValidationImpl implements ExtraInfoValidation {

    @Override
    public void validateBaseInfo(ExtraInfo model) {
        if (!model.getFirstname().matches(RegexUtility.CHECK_ENG_OR_PER_CHAR_2_50))
            throw new ExtraInfoException(ExtraInfoExceptionMessage.FIRSTNAME_IS_NOT_VALID.getExceptionMessage());
        if (!model.getLastname().matches(RegexUtility.CHECK_ENG_OR_PER_CHAR_2_50))
            throw new ExtraInfoException(ExtraInfoExceptionMessage.LASTNAME_IS_NOT_VALID.getExceptionMessage());
        LocalDate birthDate = model.getBirthDate().toLocalDate();
        Period period = Period.between(birthDate, LocalDate.now());
        if (period.getYears() <= 18)
            throw new ExtraInfoException(ExtraInfoExceptionMessage.AGE_IS_NOT_VALID.getExceptionMessage());
        if (!model.getPhone().matches(RegexUtility.CHECK_IRI_PHONE))
            throw new ExtraInfoException(ExtraInfoExceptionMessage.PHONE_IS_NOT_VALID.getExceptionMessage());
    }
}

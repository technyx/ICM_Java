package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum AddressExceptionMessage {
    ADDRESS_NOT_FOUND("ادرس یافت نشد."),
    COUNTRY_NOT_VALID("کشور معتبر نمی باشد."),
    CITY_NOT_VALID("استان وارد شده معتبر نمی باشد."),
    LOCATION_NOT_VALID("ادرس باید شامل حروف فارسی و اعداد باشد."),
    POSTAL_CODE_NOT_VALID("کد پستی باید مطابق کد پستی ایران باشد."),
    ;

    private String exceptionMessage;

    AddressExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public AddressExceptionMessage getExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        return this;
    }
}

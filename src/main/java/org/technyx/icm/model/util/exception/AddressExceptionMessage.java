package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum AddressExceptionMessage {
    ADDRESS_NOT_FOUND("ادرس یافت نشد."),
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

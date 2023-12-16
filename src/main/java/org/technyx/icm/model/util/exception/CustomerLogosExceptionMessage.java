package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum CustomerLogosExceptionMessage {
    CUSTOMERLOGO_NOT_FOUND("لوگو یافت نشد.");

    private String exceptionMessage;

    CustomerLogosExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public CustomerLogosExceptionMessage getExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        return this;
    }

}

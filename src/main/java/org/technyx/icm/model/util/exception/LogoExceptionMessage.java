package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum LogoExceptionMessage {
    LOGO_NOT_FOUND("لوگو یافت نشد."),
    URL_IS_EMPTY("مسیر ذخیره خالی است.");

    private String exceptionMessage;

    LogoExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public LogoExceptionMessage getExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        return this;
    }

}

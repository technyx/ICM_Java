package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum ExtraInfoExceptionMessage {
    EXTRA_INFO_NOT_FOUND("اطلاعات تکمیلی کاربر یافت نشد."),
    ;

    private String exceptionMessage;

    ExtraInfoExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public ExtraInfoExceptionMessage getExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        return this;
    }
}

package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum FaqExceptionMessage {
    ANSWER_NOT_FOUND("پاسخ یافت نشد.");

    private String exceptionMessage;

    FaqExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public FaqExceptionMessage getExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        return this;
    }
}

package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum ExtraInfoExceptionMessage {
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

package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum PermissionExceptionMessage {
    TITLE_NOT_FOUND("عنوان یافت نشد.");

    private String exceptionMessage;

    PermissionExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public PermissionExceptionMessage getExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        return this;
    }

}

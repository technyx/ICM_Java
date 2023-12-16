package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum FileExceptionMessage {
    FILE_NOT_FOUND("فایل یافت نشد.");

    private String exceptionMessage;

    FileExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public FileExceptionMessage getExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        return this;
    }
}

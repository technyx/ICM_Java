package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum FileExceptionMessage {
    FILE_NOT_FOUND("فایل یافت نشد."),
    DISCRIMINATOR_IS_EMPTY("تبعیض کننده خالی می باشد."),
    URL_IS_EMPTY("مسیر ذخیره سازی خالی می باشد."),
    ;

    private String exceptionMessage;

    FileExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public FileExceptionMessage getExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        return this;
    }
}

package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum ContentExceptionMessage {
    TITLE_IS_EMPTY("عنوان مطلب خالی می باشد."),
    DESCRIPTION_IS_EMPTY("متن مطلب خالی می باشد."),
    CONTENT_FILE_IS_EMPTY("فایل های مطلب خالی می باشد."),
    CONTENT_FILE_FOR_PARTNER_IS_ONE("فایل های پارتنر نباید بیشتر از یکی باشد."),
    CONTENT_NOT_FOUND("مطلب یافت نشد."),
;

    private String exceptionMessage;

    ContentExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public ContentExceptionMessage getExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        return this;
    }
}

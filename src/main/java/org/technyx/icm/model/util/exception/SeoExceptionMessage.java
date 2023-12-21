package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum SeoExceptionMessage {
    SEO_NOT_FOUND("س‌ءو مد نظر یافت نشد."),
    SEO_TITLE_IS_EMPTY("عنوان خالی می باشد."),
    SEO_DESCRIPTION_IS_EMPTY("متن خالی می باشد."),
    ;

    private String exceptionMessage;

    SeoExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public SeoExceptionMessage setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        return this;
    }
}

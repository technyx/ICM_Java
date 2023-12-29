package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum InfoExceptionMessage {
    INFO_NOT_FOUND("درباره من یافت نشد."),
    INFO_TITLE_MUST_BE_AT_LEAST_8_CHAR("طول عنوان درباره باید حداقل 8 کاراکتر باشد."),
    INFO_TEXT_MUST_BE_AT_LEAST_8_CHAR("طول متن درباره باید حداقل 8 کاراکتر باشد."),
    INFO_FILE_MUST_BE_AT_LEAST_2("حداقل دو فایل باید با درباره باشد."),
    INFO_FILE_MUST_BE_AT_EMPTY("حداقل فایل باید با درباره باشد."),
    INFO_DISCRIMINATOR_IS_BLANK("حداقل دو فایل باید با درباره باشد."),
    ;

    private String exceptionMessage;

    InfoExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public InfoExceptionMessage getExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        return this;
    }
}

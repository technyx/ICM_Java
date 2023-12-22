package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum ServiceExceptionMessage {
    SERVICE_NOT_FOUND("سرویس یافت نشد."),
    SERVICE_TITLE_IS_EMPTY("عنوان سرویس خالی می باشد."),
    SERVICE_DESCRIPTION_IS_EMPTY("متن سرویس خالی می باشد."),
    SERVICE_ICON_IS_EMPTY("ایکن سرویس خالی می باشد."),
    ;

    private String exceptionMessage;

    ServiceExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public ServiceExceptionMessage setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        return this;
    }
}

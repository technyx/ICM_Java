package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum UserExceptionMessages {
    USER_NOT_FOUND("کاربر یافت نشد!"),
    ;

    private String errorMessage;

    UserExceptionMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public UserExceptionMessages setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
}

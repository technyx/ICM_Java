package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum UserExceptionMessages {
    USER_NOT_FOUND("کاربر یافت نشد!"),
    USER_USERNAME_NOT_VALID("رمز عبور باید به طول 6 تا 20 و شامل عدد و کاراکتر باشد."),
    USER_PASSWORD_NOT_VALID("رمز عبور به طول 8 رقم و شامل عدد و کاراکتر باشد."),
    USER_ROLE_NOT_VALID("نقش کاربر در سیستم تعریف نشده است."),
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

package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum UserExceptionMessages {
    USER_NOT_FOUND("کاربر یافت نشد."),
    USER_USERNAME_NOT_VALID_REGISTER("نام کاربری باید بین ۶ تا ۲۰ کاراکتر و شامل عدد و حروف باشد."),
    USER_USERNAME_PASSWORD_NOT_VALID_LOGIN("رمز عبور یا نام کاربری معتبر نمی باشد."),
    USER_PASSWORD_NOT_VALID_REGISTER("رمز عبور حداقل باید ۸ کاراکتر و شامل عدد و حروف باشد."),
    USER_ROLE_NOT_VALID("نقش کاربر در سیستم تعریف نشده است."),
    NATIONAL_CODE_NOT_VALID("کد ملی اشتباه وارد شده است."),
    ;

    private String exceptionMessage;

    UserExceptionMessages(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public UserExceptionMessages setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        return this;
    }
}

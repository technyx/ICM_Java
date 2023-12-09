package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum ExtraInfoExceptionMessage {
    EXTRA_INFO_NOT_FOUND("اطلاعات تکمیلی کاربر یافت نشد."),
    FIRSTNAME_IS_NOT_VALID("نام باید تنها از حروف الفبای فارسی و انگلیسی و مابین 2 تا 50 کاراکتر باشد."),
    LASTNAME_IS_NOT_VALID("نام خانوادگی باید تنها از حروف الفبای فارسی و انگلیسی و مابین 2 تا 50 کاراکتر باشد."),
    AGE_IS_NOT_VALID("سن کاربر باید بالای 18 سال باشد."),
    PHONE_IS_NOT_VALID("شماره تلفن وارد شده برای کاربر صحیح نمی باشد."),
    ;

    private String exceptionMessage;

    ExtraInfoExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public ExtraInfoExceptionMessage getExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        return this;
    }
}

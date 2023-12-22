package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum GalleryExceptionMessage {
    GALLERY_NOT_FOUND("گالری یافت نشد."),
    GALLERY_TITLE_IS_EMPTY("متن گالری خالی می باشد."),
    GALLERY_FILE_IS_EMPTY("فایل گالری خالی می باشد"),
    ;

    private String exceptionMessage;

    GalleryExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public GalleryExceptionMessage getExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        return this;
    }
}

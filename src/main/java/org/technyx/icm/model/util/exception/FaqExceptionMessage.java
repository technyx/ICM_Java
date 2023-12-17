package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum FaqExceptionMessage {
    FAQ_NOT_FOUND("سوال متداول مد نظر یافت نشد."),
    QUESTION_IS_EMPTY("متن سوال خالی می باشد."),
    ANSWER_IS_EMPTY("متن جواب خالی می باشد."),
    ;

    private String exceptionMessage;

    FaqExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public FaqExceptionMessage getExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        return this;
    }
}

package org.technyx.icm.model.util.exception;

import lombok.Getter;

@Getter
public enum PaySlipExceptionMessage {
    PAY_SLIP_NOT_FOUND("فیش حقوقی مد نظر یافت نشد.");

    private String exceptionMessage;

    PaySlipExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public PaySlipExceptionMessage getExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        return this;
    }
}

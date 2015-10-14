package com.orvyl.sample.swf.checkout.activities.api.exception;

/**
 * Created by vyl on 10/14/15.
 */
public class InvalidReceiptException extends Exception {
    public InvalidReceiptException() {
        super();
    }

    public InvalidReceiptException(String message) {
        super(message);
    }

    public InvalidReceiptException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidReceiptException(Throwable cause) {
        super(cause);
    }

    protected InvalidReceiptException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

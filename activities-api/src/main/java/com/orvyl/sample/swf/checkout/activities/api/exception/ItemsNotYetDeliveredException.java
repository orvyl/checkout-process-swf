package com.orvyl.sample.swf.checkout.activities.api.exception;

/**
 * Created by vyl on 10/14/15.
 */
public class ItemsNotYetDeliveredException extends Exception {
    public ItemsNotYetDeliveredException() {
        super();
    }

    public ItemsNotYetDeliveredException(String message) {
        super(message);
    }

    public ItemsNotYetDeliveredException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemsNotYetDeliveredException(Throwable cause) {
        super(cause);
    }

    protected ItemsNotYetDeliveredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

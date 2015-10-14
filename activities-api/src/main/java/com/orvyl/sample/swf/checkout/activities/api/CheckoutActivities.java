package com.orvyl.sample.swf.checkout.activities.api;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;
import com.amazonaws.services.simpleworkflow.flow.annotations.ExponentialRetry;
import com.orvyl.sample.swf.checkout.activities.api.domain.Order;
import com.orvyl.sample.swf.checkout.activities.api.domain.Receipt;
import com.orvyl.sample.swf.checkout.activities.api.domain.ShipOrderTxn;
import com.orvyl.sample.swf.checkout.activities.api.domain.VerifiedOrder;
import com.orvyl.sample.swf.checkout.activities.api.exception.InvalidReceiptException;
import com.orvyl.sample.swf.checkout.activities.api.exception.ItemsNotYetDeliveredException;

/**
 * Created by vyl on 10/2/15.
 */
@Activities(version = "1.1")
@ActivityRegistrationOptions(
        defaultTaskScheduleToStartTimeoutSeconds = 86400, // task can wait 86400sec before processing
        defaultTaskStartToCloseTimeoutSeconds = 30 // activity can process for 30sec
)
public interface CheckoutActivities {
    VerifiedOrder verifyOrder(Order order);

    Receipt chargeCreditCard(VerifiedOrder order);

    @ExponentialRetry(initialRetryIntervalSeconds = 5, maximumAttempts = 15, exceptionsToRetry = {ItemsNotYetDeliveredException.class})
    ShipOrderTxn shipOrder(VerifiedOrder order, Receipt receipt) throws ItemsNotYetDeliveredException, InvalidReceiptException;

    void recordCompletion(VerifiedOrder verifiedOrder, Receipt receipt, ShipOrderTxn shipOrderTxn);
}

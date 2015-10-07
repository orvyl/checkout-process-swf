package com.orvyl.sample.swf.checkout.activities.api;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;
import com.orvyl.sample.swf.checkout.activities.api.domain.Order;
import com.orvyl.sample.swf.checkout.activities.api.domain.Receipt;
import com.orvyl.sample.swf.checkout.activities.api.domain.ShipOrderTxn;

/**
 * Created by vyl on 10/2/15.
 */
@Activities(version = "1.0")
@ActivityRegistrationOptions(
        defaultTaskScheduleToStartTimeoutSeconds = 86400, // max of 1 day per activity
        defaultTaskStartToCloseTimeoutSeconds = 30 // max of 30 seconds for every activity to finish task
)
public interface CheckoutActivities {
    Order verifyOrder(Order order);
    Receipt chargeCreditCard(Order order);
    ShipOrderTxn shipOrder(Order order);
    void recordCompletion(Order order, Receipt receipt, ShipOrderTxn shipOrderTxn);
}

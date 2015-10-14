package com.orvyl.sample.swf.checkout.decider;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.orvyl.sample.swf.checkout.activities.api.CheckoutActivitiesClient;
import com.orvyl.sample.swf.checkout.activities.api.CheckoutActivitiesClientImpl;
import com.orvyl.sample.swf.checkout.activities.api.domain.Order;
import com.orvyl.sample.swf.checkout.activities.api.domain.Receipt;
import com.orvyl.sample.swf.checkout.activities.api.domain.ShipOrderTxn;
import com.orvyl.sample.swf.checkout.activities.api.domain.VerifiedOrder;
import com.orvyl.sample.swf.checkout.workflow.api.CheckoutWorkflow;

/**
 * Created by vyl on 10/2/15.
 */
public class CheckoutDecider implements CheckoutWorkflow {

    private final CheckoutActivitiesClient activitiesClient = new CheckoutActivitiesClientImpl();

    @Override
    public void execute(Order order) {
        Promise<VerifiedOrder> verifiedOrder = activitiesClient.verifyOrder(order);
        Promise<Receipt> receipt = activitiesClient.chargeCreditCard(verifiedOrder);
        Promise<ShipOrderTxn> shipOrderTxn = activitiesClient.shipOrder(verifiedOrder, receipt);
        activitiesClient.recordCompletion(verifiedOrder, receipt, shipOrderTxn);
    }
}

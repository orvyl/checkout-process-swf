package com.orvyl.sample.swf.checkout.activities;

import com.orvyl.sample.swf.checkout.activities.api.CheckoutActivities;
import com.orvyl.sample.swf.checkout.activities.api.domain.Order;
import com.orvyl.sample.swf.checkout.activities.api.domain.Receipt;
import com.orvyl.sample.swf.checkout.activities.api.domain.ShipOrderTxn;

import java.util.Date;
import java.util.UUID;

/**
 * Created by vyl on 10/2/15.
 */
public class CheckoutActivitiesImpl implements CheckoutActivities {
    @Override
    public Order verifyOrder(Order order) {
        // TODO add verifyOrder implementation
        return order;
    }

    @Override
    public Receipt chargeCreditCard(Order order) {
        Receipt receipt = new Receipt(UUID.randomUUID().toString());
        receipt.setDate(new Date());

        // TODO add chargeCreditCard implementation

        return receipt;
    }

    @Override
    public ShipOrderTxn shipOrder(Order order) {
        ShipOrderTxn shipOrderTxn = new ShipOrderTxn(UUID.randomUUID().toString());
        shipOrderTxn.setDate(new Date());

        // TODO add shipOrder implementation

        return shipOrderTxn;
    }

    @Override
    public void recordCompletion(Order order, Receipt receipt, ShipOrderTxn shipOrderTxn) {
        // TODO add recordCompletion implementation
    }
}

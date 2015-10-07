package com.orvyl.sample.swf.checkout.activities;

import com.orvyl.sample.swf.checkout.activities.api.CheckoutActivities;
import com.orvyl.sample.swf.checkout.activities.api.domain.Order;
import com.orvyl.sample.swf.checkout.activities.api.domain.Receipt;
import com.orvyl.sample.swf.checkout.activities.api.domain.ShipOrderTxn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.UUID;

/**
 * Created by vyl on 10/2/15.
 */
public class CheckoutActivitiesImpl implements CheckoutActivities {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutActivitiesImpl.class);

    @Override
    public Order verifyOrder(Order order) {
        LOGGER.info("** verifyOrder() **");

        LOGGER.info("OrderId to be verified: " + order.getId());
        LOGGER.info("verifying...");
        LOGGER.info("verified!");

        return order;
    }

    @Override
    public Receipt chargeCreditCard(Order order) {
        LOGGER.info("** chargeCreditCard() **");

        LOGGER.info("User to charge: " + order.getCustomer().getName());
        LOGGER.info("verifying card...");
        LOGGER.info("Card verified and charged!");

        Receipt receipt = new Receipt(UUID.randomUUID().toString());
        receipt.setDate(new Date());
        receipt.setSuccess(true);
        receipt.setDescription("Successful!");

        return receipt;
    }

    @Override
    public ShipOrderTxn shipOrder(Order order) {
        LOGGER.info("** shipOrder() **");

        LOGGER.info("# of items to be delivered: " + order.getItems().size());
        LOGGER.info("Items now ready for delivery!");

        ShipOrderTxn shipOrderTxn = new ShipOrderTxn(UUID.randomUUID().toString());
        shipOrderTxn.setDate(new Date());
        shipOrderTxn.setReceiverName(order.getCustomer().getName());
        shipOrderTxn.setDeliveryAddress(order.getCustomer().getAddress());

        return shipOrderTxn;
    }

    @Override
    public void recordCompletion(Order order, Receipt receipt, ShipOrderTxn shipOrderTxn) {
        LOGGER.info("** recordCompletion() **");

        LOGGER.info("Saving order: " + order);
        LOGGER.info("Saving receipt: " + receipt);
        LOGGER.info("Saving shipOrderTxn: " + shipOrderTxn);
        LOGGER.info("record completion done!");
    }
}

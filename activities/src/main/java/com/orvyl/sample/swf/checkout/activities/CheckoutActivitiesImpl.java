package com.orvyl.sample.swf.checkout.activities;

import com.orvyl.sample.swf.checkout.activities.api.CheckoutActivities;
import com.orvyl.sample.swf.checkout.activities.api.domain.*;
import com.orvyl.sample.swf.checkout.activities.api.exception.InvalidReceiptException;
import com.orvyl.sample.swf.checkout.activities.api.exception.ItemsNotYetDeliveredException;

import java.util.Date;
import java.util.UUID;

/**
 * Created by vyl on 10/2/15.
 */
public class CheckoutActivitiesImpl implements CheckoutActivities {

    @Override
    public VerifiedOrder verifyOrder(Order order) {
        System.out.println("************ verifyOrder() ************");
        System.out.println("verifying the order: " + order.getId());
        System.out.println("Order verified!");

        VerifiedOrder verifiedOrder = new VerifiedOrder();
        verifiedOrder.setVerified(true);
        verifiedOrder.setDescription("Order " + order.getId() + " verified");
        verifiedOrder.setOrder(order);

        return verifiedOrder;
    }

    @Override
    public Receipt chargeCreditCard(VerifiedOrder vOrder) {
        Order order = vOrder.getOrder();

        System.out.println("************ chargeCreditCard() ************");
        System.out.println("User to charge: " + order.getCustomer().getName());
        System.out.println("Verifying Payment information...");

        String referenceNo = UUID.randomUUID().toString();
        System.out.println("Transaction completed. Reference No: " + referenceNo);

        Receipt receipt = new Receipt(referenceNo);
        receipt.setDate(new Date());
        receipt.setSuccess(true);
        receipt.setDescription("Successful!");

        return receipt;
    }

    @Override
    public ShipOrderTxn shipOrder(VerifiedOrder vOrder, Receipt receipt) throws ItemsNotYetDeliveredException, InvalidReceiptException {
        Order order = vOrder.getOrder();

        if (!receipt.getSuccess()) throw new InvalidReceiptException("Invalid receipt");

        System.out.println("************ shipOrder() ************");

        System.out.println("Delivery address: " + order.getCustomer().getAddress());
        System.out.println("Items to be delivered:");
        for (Item item : order.getItems()) {
            System.out.println(" - " + item.getQuantity() + " " + item.getName());
        }

        // to simulate long process of shipping order
        long diff = ((new Date()).getTime() - vOrder.getDate().getTime()) / 1000;
        if (diff < 15) throw new ItemsNotYetDeliveredException("Items not yet delivered");

        System.out.println("Items delivered!");

        ShipOrderTxn shipOrderTxn = new ShipOrderTxn(UUID.randomUUID().toString());
        shipOrderTxn.setDate(new Date());
        shipOrderTxn.setReceiverName(order.getCustomer().getName());
        shipOrderTxn.setDeliveryAddress(order.getCustomer().getAddress());

        return shipOrderTxn;
    }

    @Override
    public void recordCompletion(VerifiedOrder verifiedOrder, Receipt receipt, ShipOrderTxn shipOrderTxn) {
        System.out.println("************ recordCompletion() ************");
        System.out.println("Saving order: " + verifiedOrder);
        System.out.println("Saving receipt: " + receipt);
        System.out.println("Saving shipOrderTxn: " + shipOrderTxn);
    }
}

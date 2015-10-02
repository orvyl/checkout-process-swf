package com.orvyl.sample.swf.checkout.activities.api.domain;

import java.util.Date;

/**
 * Created by vyl on 10/2/15.
 */
public class ShipOrderTxn {
    private String referenceNo;
    private String deliveryAddress;
    private String receiverName;
    private Date date;

    public ShipOrderTxn(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

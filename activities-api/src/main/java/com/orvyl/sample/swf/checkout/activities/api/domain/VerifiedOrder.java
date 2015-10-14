package com.orvyl.sample.swf.checkout.activities.api.domain;

import java.util.Date;

/**
 * Created by vyl on 10/13/15.
 */
public class VerifiedOrder {
    private Boolean verified;
    private String description;
    private Order order;
    private Date date;

    public VerifiedOrder() {
        date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public Boolean isVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "VerifiedOrder{" +
                "verified=" + verified +
                ", description='" + description + '\'' +
                ", order=" + order +
                '}';
    }
}

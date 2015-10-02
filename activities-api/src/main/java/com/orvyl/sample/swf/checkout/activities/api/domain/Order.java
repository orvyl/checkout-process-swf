package com.orvyl.sample.swf.checkout.activities.api.domain;

import java.util.List;

/**
 * Created by vyl on 10/2/15.
 */
public class Order {
    private String id;
    private List<Item> items;
    private Double subTotal;
    private Customer customer;

    public Order(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

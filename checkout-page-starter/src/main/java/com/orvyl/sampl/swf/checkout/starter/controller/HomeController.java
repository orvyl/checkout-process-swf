package com.orvyl.sampl.swf.checkout.starter.controller;

import com.orvyl.sample.swf.checkout.activities.api.domain.Customer;
import com.orvyl.sample.swf.checkout.activities.api.domain.Item;
import com.orvyl.sample.swf.checkout.activities.api.domain.Order;
import com.orvyl.sample.swf.checkout.workflow.api.CheckoutWorkflowAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by vyl on 10/5/15.
 */
@Controller
public class HomeController {

    @Autowired
    private CheckoutWorkflowAPI api;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkout(Model model) {
        String orderId = UUID.randomUUID().toString().substring(0,9);

        model.addAttribute("orderId", orderId);

        Order order = new Order(orderId);
        order.setSubTotal(70.00);
        Customer customer = new Customer("USER123", "Banung Salazar");
        customer.setAddress("#588 HeneralLuna st. Makati City, Philippines");
        order.setCustomer(customer);
        ArrayList<Item> items = new ArrayList<>();

        Item e = new Item();
        e.setName("Tinapang maliliit");
        e.setDescription("Small dried fish");
        e.setPrice(50.00);
        items.add(e);

        Item e1 = new Item();
        e1.setName("Bagoong");
        e1.setDescription("Bagoong from Cagayan");
        e1.setPrice(15.00);
        items.add(e1);

        Item e2 = new Item();
        e2.setName("Kamatis");
        e2.setDescription("Tomato");
        e2.setPrice(5.00);
        items.add(e2);

        order.setItems(items);

        // start of the workflow execution!
        api.performCheckoutProcess(order);

        return "checkout";
    }

}

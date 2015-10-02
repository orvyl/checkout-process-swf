package com.orvyl.sample.swf.checkout.workflow.api;

import com.orvyl.sample.swf.checkout.activities.api.domain.Order;

/**
 * Created by vyl on 10/2/15.
 */
public class CheckoutWorkflowAPI {

    private CheckoutWorkflowClientExternalFactory checkoutWorkflowClientExternalFactory;

    public CheckoutWorkflowAPI(CheckoutWorkflowClientExternalFactory checkoutWorkflowClientExternalFactory) {
        this.checkoutWorkflowClientExternalFactory = checkoutWorkflowClientExternalFactory;
    }

    public void performCheckoutProcess(Order order) {
        // assign orderID as the workflow execution id for easy tracking of status in SWF management console
        CheckoutWorkflowClientExternal client = checkoutWorkflowClientExternalFactory.getClient(order.getId());
        client.execute(order);
    }
}

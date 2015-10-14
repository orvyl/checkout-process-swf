package com.orvyl.sample.swf.checkout.workflow.api;

import com.amazonaws.services.simpleworkflow.flow.annotations.Execute;
import com.amazonaws.services.simpleworkflow.flow.annotations.Workflow;
import com.amazonaws.services.simpleworkflow.flow.annotations.WorkflowRegistrationOptions;
import com.orvyl.sample.swf.checkout.activities.api.domain.Order;

/**
 * Created by vyl on 10/2/15.
 */
@Workflow
@WorkflowRegistrationOptions(
        defaultExecutionStartToCloseTimeoutSeconds = 345600 // maximum of 4 days in every workflow execution
)
public interface CheckoutWorkflow {

    @Execute(version = "1.1")
    void execute(Order order);

}

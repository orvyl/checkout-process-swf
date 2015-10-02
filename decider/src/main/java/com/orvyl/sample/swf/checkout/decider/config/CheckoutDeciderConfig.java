package com.orvyl.sample.swf.checkout.decider.config;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.flow.WorkflowWorker;
import com.orvyl.sample.swf.checkout.decider.CheckoutDecider;
import com.orvyl.sample.swf.checkout.properties.AmazonSWFProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by vyl on 10/2/15.
 */
@Configuration
@EnableConfigurationProperties
public class CheckoutDeciderConfig {

    private static final String DECIDER_TASK_LIST = "checkout-decision-list";

    @Autowired
    private AmazonSimpleWorkflow amazonSimpleWorkflow;

    @Autowired
    private AmazonSWFProperties amazonSWFProperties;

    @Bean
    public WorkflowWorker workflowWorker() throws IllegalAccessException, InstantiationException {
        WorkflowWorker worker = new WorkflowWorker(amazonSimpleWorkflow, amazonSWFProperties.getDomain(), DECIDER_TASK_LIST);
        worker.addWorkflowImplementationType(CheckoutDecider.class);

        return worker;
    }
}

package com.orvyl.sample.swf.checkout.activities.config;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.flow.ActivityWorker;
import com.orvyl.sample.swf.checkout.activities.CheckoutActivitiesImpl;
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
public class CheckoutActivitiesConfig {

    private static final String ACTIVITIES_TASK_LIST = "checkout-activities-list";

    @Autowired
    private AmazonSWFProperties amazonSWFProperties;

    @Autowired
    private AmazonSimpleWorkflow swfClient;

    @Bean
    public ActivityWorker activityWorker() throws IllegalAccessException, NoSuchMethodException, InstantiationException {
        ActivityWorker activityWorker = new ActivityWorker(swfClient, amazonSWFProperties.getDomain(), ACTIVITIES_TASK_LIST);
        activityWorker.addActivitiesImplementation(new CheckoutActivitiesImpl());

        return activityWorker;
    }

}

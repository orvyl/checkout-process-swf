package com.orvyl.sample.swf.checkout.workflow.api;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.orvyl.sample.swf.checkout.properties.AmazonSWFProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by vyl on 10/2/15.
 */
@Configuration
@EnableConfigurationProperties(AmazonSWFProperties.class)
public class CheckoutWorkflowAPIConfig {

    @Autowired
    private AmazonSimpleWorkflow amazonSimpleWorkflow;

    @Autowired
    private AmazonSWFProperties amazonSWFProperties;

    @Bean
    public CheckoutWorkflowAPI checkoutWorkflowAPI() {
        CheckoutWorkflowClientExternalFactory externalFactory =
                new CheckoutWorkflowClientExternalFactoryImpl(amazonSimpleWorkflow, amazonSWFProperties.getDomain());

        return new CheckoutWorkflowAPI(externalFactory);
    }

}

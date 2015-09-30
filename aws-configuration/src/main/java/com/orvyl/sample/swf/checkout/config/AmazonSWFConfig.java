package com.orvyl.sample.swf.checkout.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import com.orvyl.sample.swf.checkout.properties.AmazonSWFProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by vyl on 9/30/15.
 */
@Configuration
public class AmazonSWFConfig {

    @Autowired
    private AmazonSWFProperties amazonSWFProperties;

    @Bean
    public ClientConfiguration clientConfiguration() {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setSocketBufferSizeHints(0, 0);

        return clientConfiguration;
    }

    @Bean
    public AWSCredentials awsCredentials() {
        return new BasicAWSCredentials(amazonSWFProperties.getAccessKeyId(), amazonSWFProperties.getSecretAccessKey());
    }

    @Bean
    public AmazonSimpleWorkflow amazonSimpleWorkflow() {
        AmazonSimpleWorkflow workflow = new AmazonSimpleWorkflowClient(awsCredentials(), clientConfiguration());
        workflow.setRegion(Region.getRegion(Regions.fromName(amazonSWFProperties.getRegionId())));

        return workflow;
    }

}

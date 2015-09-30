package com.orvyl.sample.swf.checkout.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by vyl on 9/30/15.
 */
@Configuration
public class AmazonSWFConfig {

    @Bean
    public ClientConfiguration clientConfiguration() {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setSocketBufferSizeHints(0, 0);

        return clientConfiguration;
    }

    @Bean
    public AWSCredentials awsCredentials() {
        // TODO add keys
        return new BasicAWSCredentials("access_key_id", "secret_access_key");
    }

    @Bean
    public AmazonSimpleWorkflow amazonSimpleWorkflow() {
        AmazonSimpleWorkflow workflow = new AmazonSimpleWorkflowClient(awsCredentials(), clientConfiguration());
        // TODO add region
        workflow.setRegion(Region.getRegion(Regions.fromName("")));

        return workflow;
    }

}

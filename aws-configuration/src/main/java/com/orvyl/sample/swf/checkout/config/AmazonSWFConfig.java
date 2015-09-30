package com.orvyl.sample.swf.checkout.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
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
    public AWSCredentialsProvider awsCredentialsProvider() {
        // TODO add aws-credntial directory
        return new ProfileCredentialsProvider("");
    }

    @Bean
    public AmazonSimpleWorkflow amazonSimpleWorkflow() {
        AmazonSimpleWorkflow workflow = new AmazonSimpleWorkflowClient(awsCredentialsProvider(), clientConfiguration());
        // TODO add region
        workflow.setRegion(Region.getRegion(Regions.fromName("")));

        return workflow;
    }

}

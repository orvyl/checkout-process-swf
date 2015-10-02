package com.orvyl.sample.swf.checkout.decider;

import com.amazonaws.services.simpleworkflow.flow.WorkflowWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by vyl on 10/2/15.
 */
@SpringBootApplication
public class CheckoutDeciderApp {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(CheckoutDeciderApp.class);
        ApplicationContext applicationContext = springApplication.run(args);
        WorkflowWorker workflowWorker = applicationContext.getBean(WorkflowWorker.class);

        workflowWorker.start();
    }
}

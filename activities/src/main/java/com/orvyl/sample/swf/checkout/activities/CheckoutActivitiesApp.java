package com.orvyl.sample.swf.checkout.activities;

import com.amazonaws.services.simpleworkflow.flow.ActivityWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by vyl on 10/2/15.
 */
@SpringBootApplication
public class CheckoutActivitiesApp {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(CheckoutActivitiesApp.class);
        ApplicationContext applicationContext = springApplication.run(args);
        ActivityWorker activityWorker = applicationContext.getBean(ActivityWorker.class);

        activityWorker.start();
    }
}

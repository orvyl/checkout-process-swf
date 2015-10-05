package com.orvyl.sampl.swf.checkout.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by vyl on 10/5/15.
 */
@SpringBootApplication
public class CheckoutStarterApp {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CheckoutStarterApp.class);
        application.run(args);
    }
}

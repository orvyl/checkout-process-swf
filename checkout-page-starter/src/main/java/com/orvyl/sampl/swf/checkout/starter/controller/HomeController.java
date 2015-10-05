package com.orvyl.sampl.swf.checkout.starter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vyl on 10/5/15.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkout() {
        return "checkout";
    }

}

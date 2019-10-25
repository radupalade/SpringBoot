package com.sda.main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandingPageController {

    @RequestMapping("/")
    public String index() {
        return "pam pam";
    }

}

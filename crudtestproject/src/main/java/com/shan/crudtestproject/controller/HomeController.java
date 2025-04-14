package com.shan.crudtestproject.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

    @GetMapping("/")
    String index(Principal principal) {
        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    }

}
package com.nitish.self.teacherstudentmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.nitish.self.teacherstudentmanagement.utils.ApiConstants.*;

@RestController
@RequestMapping
public class HomeController {

    @GetMapping(ABOUT_PATH)
    public String aboutUs() {
        return "<h1>This is about us page.</h1>";
    }

    @GetMapping(CONTACT_PATH)
    public String contact() {
        return "<h1>This is contact page.</h1>";
    }

}

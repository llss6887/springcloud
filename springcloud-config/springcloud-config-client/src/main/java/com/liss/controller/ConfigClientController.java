package com.liss.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${name}")
    private String name;

    @RequestMapping("/config_test")
    public String getName(){
        return name;
    }
}

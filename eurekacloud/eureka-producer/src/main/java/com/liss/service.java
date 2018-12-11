package com.liss;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class service {
    @RequestMapping("/hello")
    public String hello(String name){
        return "hello this is first Eureka app  " + name;
    }
}

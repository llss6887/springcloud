package com.liss;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class FallBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(FallBackApplication.class, args);
    }
}

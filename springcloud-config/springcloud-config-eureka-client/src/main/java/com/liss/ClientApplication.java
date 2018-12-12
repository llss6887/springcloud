package com.liss;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ClientApplication {

    @Value("${name}")
    private String name;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @RequestMapping("/eureka_config")
    public String getConfig(){
        return name;
    }
}

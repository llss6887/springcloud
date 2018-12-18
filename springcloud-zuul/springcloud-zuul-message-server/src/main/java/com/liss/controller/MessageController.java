package com.liss.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class MessageController {
    Logger logger = (Logger) LoggerFactory.getLogger(MessageController.class);
    @RequestMapping("/message/{name}")
    public String getMessage(@PathVariable String name){
        logger.info("request two name is "+name);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name + "  测试！";
    }
}

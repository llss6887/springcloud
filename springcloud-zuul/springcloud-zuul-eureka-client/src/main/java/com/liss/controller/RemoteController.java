package com.liss.controller;

import com.liss.RemoteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemoteController {

    @Autowired
    private RemoteInterface remoteInterface;

    @RequestMapping("/message/{name}")
    public String getMessage(@PathVariable String name){
        return remoteInterface.getMessage(name);
    }
}

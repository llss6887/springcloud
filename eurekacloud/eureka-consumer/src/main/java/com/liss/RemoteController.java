package com.liss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemoteController {
    @Autowired
    private HelloRemote helloRemote;

    @GetMapping("/remote/{name}")
    public String remoteHello(@PathVariable("name") String name){
        return helloRemote.hello(name);
    }
}

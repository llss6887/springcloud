package com.liss;

import org.springframework.stereotype.Component;

@Component
public class HelloRemoteFaild implements HelloRemote {
    @Override
    public String hello(String name) {
        return "this is fail " + name;
    }
}

package com.liss;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "message-server")
public interface RemoteInterface {

    @RequestMapping("/message/{name}")
    public String getMessage(@RequestParam(value = "name") String name);
}

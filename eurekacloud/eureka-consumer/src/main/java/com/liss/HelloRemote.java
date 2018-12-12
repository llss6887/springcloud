package com.liss;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "eureka-producer", fallback = HelloRemoteFaild.class)
public interface HelloRemote {
    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name") String name);
}

package com.liss.controller;

import com.liss.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HystrixController {
    @Autowired
    private HystrixService service;

    @GetMapping("/hystrixTest/{name}")
    public String getHystrix(@PathVariable String name){
        return service.getHystrix(name);
    }

    @RequestMapping(value = "/getOrderPageList", method = RequestMethod.POST)
    @HystrixCommand(
        fallbackMethod = "getOrderPageListFallback",
        threadPoolProperties = {  //10个核心线程池,超过20个的队列外的请求被拒绝; 当一切都是正常的时候，线程池一般仅会有1到2个线程激活来提供服务
            @HystrixProperty(name = "coreSize", value = "10"),
            @HystrixProperty(name = "maxQueueSize", value = "100"),
            @HystrixProperty(name = "queueSizeRejectionThreshold", value = "20")},
        commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"), //命令执行超时时间
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"), //若干10s一个窗口内失败三次, 则达到触发熔断的最少请求量
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "30000") //断路30s后尝试执行, 默认为5s
        })
    public String getDemo(String name){
        //do ..
        return "this is ok";
    }

    public String fallBack(String name){
        System.out.println("执行降级策略");
        return "this is fail";
    }

}

package com.liss.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixException;
import org.springframework.stereotype.Service;

@Service
@DefaultProperties(defaultFallback = "failback")
public class HystrixService {

    //回调函数的参数和原的一致
    //@HystrixCommand(fallbackMethod = "failHystrix")
    @HystrixCommand(ignoreExceptions = ArithmeticException.class, raiseHystrixExceptions = HystrixException.RUNTIME_EXCEPTION)
    public String getHystrix(String name){
        //int i = 1 / 0;
        return name + ": is ok";
    }

    public String failHystrix(String name){
        return name + ": is fail";
    }
    public String failback(){
        return ": is fail";
    }
}

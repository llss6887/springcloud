package com.liss.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebFilter;

@Configuration
public class FilterConfig {
    @Bean
    public MyFilter getMyFilter(){
        return new MyFilter();
    }
}

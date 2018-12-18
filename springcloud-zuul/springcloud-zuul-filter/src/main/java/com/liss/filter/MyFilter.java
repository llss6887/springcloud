package com.liss.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpServletRequest;

public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if(StringUtils.isNotBlank(token)){
            context.setSendZuulResponse(true);
            context.setResponseStatusCode(200);
            context.set("data", true);
            return null;
        }else{
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(400);
            context.set("data", false);
            return null;
        }
    }
}

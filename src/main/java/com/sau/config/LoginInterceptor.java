package com.sau.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        return true;

    /*    String url = httpServletRequest.getRequestURI();
        if(url.toLowerCase().indexOf("login") > 0){
            return true;
        }

        HttpSession session = httpServletRequest.getSession();

        if(url.toLowerCase().indexOf("entrepreneur")>0 && !StringUtils.isEmpty(session.getAttribute("entrepreneur"))){
            return true;
        }

        httpServletResponse.sendRedirect("/index.html");

        return false;*/
    }
}

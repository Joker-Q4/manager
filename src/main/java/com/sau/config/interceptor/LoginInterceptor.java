package com.sau.config.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String url = httpServletRequest.getRequestURI();
        if(url.toLowerCase().indexOf("login") > 0 || url.toLowerCase().indexOf("register") > 0){
            return true;
        }

        HttpSession session = httpServletRequest.getSession();

        if(url.indexOf("html")>0){
            if((url.toLowerCase().indexOf("pages")>0
                    || url.toLowerCase().endsWith("index.html"))
                    && !StringUtils.isEmpty(session.getAttribute("admin"))){
                return true;
            }
            httpServletResponse.sendRedirect("/login.html");
            return false;
        }
        return true;
    }
}

package com.sau.config;

import com.sau.config.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Configurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns("/**");                      //所有路径都被拦截
        registration.excludePathPatterns(                         //添加不拦截路径
              //  "/**"//,
                "/**/menu",            //登录
                "/**/*.js",              //js静态资源
                "/**/*.css",             //css静态资源
                "/**/*.woff",
                "/**/*.woff2",
                "/**/*.jpg",
                "/**/*.png",
                "/**/*.gif",
                "/**/*.json",
                "/**/*.map",
                "/**/*.svg",
                "/**/*.ttf",
                "/**/layuimini",
                "/menu",            //登录
                "/*.js",              //js静态资源
                "/*.css",             //css静态资源
                "/*.woff",
                "/*.woff2",
                "/*.jpg",
                "/*.gif",
                "/*.png",
                "/*.json",
                "/*.map",
                "/*.svg",
                "/*.ttf",
                "/layuimini"
        );
    }
}

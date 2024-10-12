package com.develhope.middleware_02.config;

import com.develhope.middleware_02.interceptors.MonthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    // parameters
    @Autowired
    private MonthInterceptor monthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(monthInterceptor)
                .addPathPatterns("/months/**");  // Apply the interceptor to /months/** paths
    }
}

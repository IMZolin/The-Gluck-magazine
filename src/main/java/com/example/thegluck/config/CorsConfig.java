package com.example.thegluck.config;

import com.example.thegluck.service.AuthorizationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class CorsConfig extends WebMvcConfig {
    public CorsConfig(AuthorizationInterceptor authorizationInterceptor) {
        super(authorizationInterceptor);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}

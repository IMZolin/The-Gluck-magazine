package com.example.thegluck.service;

import com.example.thegluck.exception.NoBearerTokenException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {
    private final AuthService authService;

    public AuthorizationInterceptor(AuthService authService) {
        this.authService = authService;
    }
    @SneakyThrows
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        String authorizationHeader = request.getHeader("Authorization");
        if(authorizationHeader == null || !authorizationHeader.startsWith("Bearer "))
            throw new NoBearerTokenException("Header hasn't Bearer token");
            /*try {
                throw new NoBearerTokenException("Header hasn't Bearer token");
            } catch (NoBearerTokenException e) {
                throw new RuntimeException(e);
            }*/
        request.setAttribute("user",authService.getUserFromToken(authorizationHeader.substring(7)));
        return true;
    }
}

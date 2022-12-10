package com.example.thegluck.controller;

import com.example.thegluck.entity.UserEntity;
import com.example.thegluck.exception.NotMatchPasswordException;
import com.example.thegluck.exception.UserAlreadyExistException;
import com.example.thegluck.exception.UserNotFoundException;
import com.example.thegluck.model.User;
import com.example.thegluck.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private AuthService authService;
    record SignupRequest(String username,
                         String first_name,
                         String last_name,
                         String email,
                         String password,
                         String password_confirm
    ){}
    record SignupResponse(Long id,
                          String username,
                          String first_name,
                          String last_name,
                          String email
    ){}
    record LoginRequest(String email, String password){}
    record LoginResponse(String token){}

    @PostMapping(value ="/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) throws UserAlreadyExistException, NotMatchPasswordException {
        try {
            var user = authService.signup(
                    signupRequest.username(),
                    signupRequest.first_name(),
                    signupRequest.last_name(),
                    signupRequest.email(),
                    signupRequest.password(),
                    signupRequest.password_confirm()
            );
            SignupResponse signupResponse = new SignupResponse(user.getId(),user.getUsername(), user.getFirst_name(), user.getLast_name(),user.getEmail());
            return ResponseEntity.ok(signupResponse);
        } catch (UserAlreadyExistException | NotMatchPasswordException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        try {
            /*String userName = loginService.login(user);
            return ResponseEntity.ok(userName);*/
            var login = authService.login(loginRequest.email(), loginRequest.password());
            Cookie cookie = new Cookie("refresh_token", login.getRefreshToken().getToken());
            cookie.setMaxAge(3600);
            cookie.setHttpOnly(true);
            cookie.setPath("/api");
            response.addCookie(cookie);
            LoginResponse loginResponse  = new LoginResponse(login.getAccessToken().getToken());
            return ResponseEntity.ok(loginResponse);
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
    record RefreshResponse(String token){}
    @PostMapping(value = "/refresh")
    public RefreshResponse refresh(@CookieValue("refresh_token") String refreshToken){
        return new RefreshResponse(authService.refreshAccess(refreshToken).getAccessToken().getToken());
    }
    record LogoutResponse(String message) {}
    @PostMapping(value = "/logout")
    public LogoutResponse logout(HttpServletResponse response){
        Cookie cookie = new Cookie("refresh_token", null);
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return new LogoutResponse("success");
    }
}

package com.example.travelblog.controller;

import com.example.travelblog.config.JwtUtil;
import com.example.travelblog.controller.request.UserRequest;
import com.example.travelblog.controller.response.LoginResponse;
import com.example.travelblog.models.User;
import com.example.travelblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @created 10/08/2023 - 9:32 AM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    private final UserService userService;

    @PostMapping("/signup")
    public User createUser(@RequestBody UserRequest request ){
        return userService.addUser(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody User requset){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requset.getEmail(), requset.getPassword())
        );
        final User user = userService.findByEmail(requset.getEmail());
        String token = jwtUtil.generateToken(user);
        return new LoginResponse(user, token);
    }
}

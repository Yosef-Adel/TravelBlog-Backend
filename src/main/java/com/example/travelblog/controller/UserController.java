package com.example.travelblog.controller;

import com.example.travelblog.models.User;
import com.example.travelblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * @created 10/08/2023 - 10:33 AM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/me")
    public User getMyData(Authentication authentication){
        return ((User) authentication.getPrincipal());
    }

    @GetMapping("{id}")
    public User getUserData(@PathVariable("id") Long id){
        return userService.findById(id);
    }

}
package com.example.travelblog.controller;

import com.example.travelblog.controller.response.MsgResponse;
import com.example.travelblog.models.Role;
import com.example.travelblog.models.User;
import com.example.travelblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/*
 * @created 10/08/2023 - 10:33 AM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
@RestController
@CrossOrigin

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

    @PutMapping("/me/make-guide")
    public MsgResponse makeMeGuide(Authentication authentication){
        userService.attachRoleToUser(((User) authentication.getPrincipal()).getEmail(), "ROLE_GUIDE");
        return new MsgResponse("You are now a guide", true);
    }


    // TODO: 10/08/2023 1- Create a new endpoint to get all users

    // TODO: 10/08/2023 2- Create a new endpoint to get all guides

    // TODO: delete user by id

    // TODO: update user data by the user himself



}
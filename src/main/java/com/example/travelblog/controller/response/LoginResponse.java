package com.example.travelblog.controller.response;

import com.example.travelblog.models.User;
import lombok.AllArgsConstructor;

/*
 * @created 10/08/2023 - 9:33 AM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
@AllArgsConstructor
public class LoginResponse {
    public User user;
    public  String token;


}
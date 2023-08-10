package com.example.travelblog;

import com.example.travelblog.controller.request.UserRequest;
import com.example.travelblog.models.Role;
import com.example.travelblog.models.User;
import com.example.travelblog.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TravelBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelBlogApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(UserService userService) {
        return args -> {
            userService.addRole(new Role("ROLE_USER"));
            userService.addRole(new Role("ROLE_GUIDE"));
            userService.addRole(new Role("ROLE_ADMIN"));


            UserRequest user = new UserRequest("yosef", "yosef@gmail.com", "fun123");
            userService.addUser(user);
            userService.attachRoleToUser("yosef@gmail.com", "ROLE_ADMIN");
        };
    }

}

package com.example.travelblog.controller.request;

import lombok.*;

/*
 * @created 10/08/2023 - 10:31 AM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class UserRequest {
    private String name;
    private String email ;
    private String password;
}
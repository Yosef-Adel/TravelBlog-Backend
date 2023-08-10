package com.example.travelblog.dao;

import com.example.travelblog.models.User;

import java.util.Optional;

/*
 * @created 10/08/2023 - 9:05 AM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
public interface UserDao {
    Optional<User> findByEmail(String email);
    Optional<User> getUserById(Long id);

    User updateUser( User user);
    User addUser(User user);

    boolean isEmailExist(String email);

}

package com.example.travelblog.service;

import com.example.travelblog.models.Role;
import com.example.travelblog.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/*
 * @created 10/08/2023 - 9:11 AM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
public interface UserService extends UserDetailsService {
    User findByEmail(String email);

    User findById(Long id);

    // TODO: 10/08/2023  add the UserRequest class and use it instead of User
    User addUser(User user);
    Role addRole(Role role);
    void attachRoleToUser(String userName, String roleName);
}

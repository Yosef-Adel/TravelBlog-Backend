package com.example.travelblog.service.impl;

import com.example.travelblog.dao.RoleDao;
import com.example.travelblog.dao.UserDao;
import com.example.travelblog.models.Role;
import com.example.travelblog.models.User;
import com.example.travelblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/*
 * @created 10/08/2023 - 9:12 AM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User with email [%s] not found".formatted(email)));
    }

    @Override
    public User findById(Long id) {
        return userDao.getUserById(id).orElseThrow(()-> new UsernameNotFoundException("User with id [%s] not found".formatted(id)));
    }

    @Override
    public User addUser(User user) {

        if (userDao.isEmailExist(user.getEmail())){
            throw new UsernameNotFoundException("Email Already Exists.....");
        }
        String pass = user.getPassword();
        String hashPass = passwordEncoder.encode(pass);
        user.setPassword(hashPass);
        User newuser = userDao.addUser(new User(
                user.getName(),
                user.getEmail(),
                user.getPassword()
        ));
        this.attachRoleToUser(user.getEmail(), "ROLE_USER");
        return newuser;
    }

    @Override
    public Role addRole(Role role) {
        return roleDao.addRole(role);
    }

    @Override
    public void attachRoleToUser(String email, String roleName) {
        Role r = roleDao.findByName(roleName);
        System.out.println("attachRoleToUser " + email);
        User u = this.findByEmail(email);
        u.addRole(r);
        userDao.updateUser(u);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid Email or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),user.mapRolesToAuthorities());
    }
}
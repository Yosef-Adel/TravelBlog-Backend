package com.example.travelblog.dao.impl;

import com.example.travelblog.dao.UserDao;
import com.example.travelblog.models.User;
import com.example.travelblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 * @created 10/08/2023 - 9:06 AM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean isEmailExist(String email) {
        return userRepository.existsUserByEmail(email);
    }
}

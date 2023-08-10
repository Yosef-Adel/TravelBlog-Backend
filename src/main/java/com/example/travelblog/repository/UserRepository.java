package com.example.travelblog.repository;

import com.example.travelblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
 * @created 10/08/2023 - 9:04 AM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    boolean existsUserByEmail(String email);
}

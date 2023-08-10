package com.example.travelblog.repository;

import com.example.travelblog.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @created 10/08/2023 - 9:04 AM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
public interface RoleRepository  extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
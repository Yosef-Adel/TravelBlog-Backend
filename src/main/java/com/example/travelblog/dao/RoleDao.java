package com.example.travelblog.dao;

import com.example.travelblog.models.Role;

/*
 * @created 10/08/2023 - 9:05 AM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
public interface RoleDao {

    Role findByName(String name);

    Role addRole(Role role);

    void deleteRole(Long id);
}
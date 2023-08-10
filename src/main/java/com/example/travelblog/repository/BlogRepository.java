package com.example.travelblog.repository;

import com.example.travelblog.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*
 * @created 10/08/2023 - 12:39 PM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
public interface  BlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "SELECT *FROM Blog B WHERE B.user_id=(:ID)", nativeQuery = true)
    List<Blog> getUserPosts(@Param("ID") long id);
}

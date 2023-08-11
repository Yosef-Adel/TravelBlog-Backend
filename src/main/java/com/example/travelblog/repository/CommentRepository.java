package com.example.travelblog.repository;

import com.example.travelblog.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*
 * @created 10/08/2023 - 12:44 PM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query(value = "SELECT *FROM comment c WHERE c.blog_id=(:ID)", nativeQuery = true)
    List<Comment> findCommentByPostId(@Param("ID") long id);
}

package com.example.travelblog.repository;

import com.example.travelblog.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @created 10/08/2023 - 12:44 PM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {
}

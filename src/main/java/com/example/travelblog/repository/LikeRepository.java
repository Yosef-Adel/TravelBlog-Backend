package com.example.travelblog.repository;

import com.example.travelblog.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @created 10/08/2023 - 12:43 PM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
public interface LikeRepository extends JpaRepository<Like,Long> {
}

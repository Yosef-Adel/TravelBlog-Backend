package com.example.travelblog.dao;

import com.example.travelblog.models.Blog;

import java.util.List;

/*
 * @created 10/08/2023 - 12:45 PM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
public interface BlogDao {

    List<Blog> getAllBlogs();

    Blog CreateBlog(Blog blog);

    Blog updateBlog(long id, Blog blog);

    boolean deleteBlog(long id);

    List<Blog> getBlogByUser(long id);

    Blog getBlogById(long id);


}

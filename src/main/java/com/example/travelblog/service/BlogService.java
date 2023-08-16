package com.example.travelblog.service;

import com.example.travelblog.controller.request.BlogRequest;
import com.example.travelblog.models.Blog;
import com.example.travelblog.models.User;

import java.util.List;

/*
 * @created 10/08/2023 - 1:10 PM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
public interface BlogService {

    List<Blog> getBlogs();

    Blog getBlogById(long id);

    Blog createBlog(BlogRequest blog, User user);

    Blog updateBlog(long id, BlogRequest blog, User user);

    boolean deleteBlog(long id, User user);

    List<Blog> getBlogsByUserId(long id);
}

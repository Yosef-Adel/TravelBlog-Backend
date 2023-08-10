package com.example.travelblog.service.impl;

import com.example.travelblog.controller.request.BlogRequest;
import com.example.travelblog.dao.BlogDao;
import com.example.travelblog.exception.UnAuthrized;
import com.example.travelblog.models.Blog;
import com.example.travelblog.models.User;
import com.example.travelblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/*
 * @created 10/08/2023 - 1:12 PM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */

@Service
@RequiredArgsConstructor
public class BlogServiceImpl  implements BlogService {
    private final BlogDao blogDao;

    @Override
    public List<Blog> getBlogs() {
        return blogDao.getAllBlogs();
    }

    @Override
    public Blog getBlogById(long id) {
        return blogDao.getBlogById(id);
    }

    @Override
    public Blog createBlog(BlogRequest blog, User user) {
        Blog newBlog = new Blog();
        newBlog.setUser(user);
        newBlog.setTitle(blog.getTitle());
        newBlog.setContent(blog.getContent());
        newBlog.setPicture(blog.getPicture());
        return blogDao.CreateBlog(newBlog);
    }

    @Override
    public Blog updateBlog(long id, BlogRequest blogRequest, User user) {
        Blog blog = blogDao.getBlogById(id);
        if (!Objects.equals(blog.getUser().getId(), user.getId()) && !user.isAdmin()) {
            throw new UnAuthrized("you not authrized to delete the post");
        }

        Blog newBlog = new Blog();
        newBlog.setUser(user);
        newBlog.setTitle(blogRequest.getTitle());
        newBlog.setContent(blogRequest.getContent());
        newBlog.setPicture(blogRequest.getPicture());
        return blogDao.updateBlog(id, newBlog);
    }


    // TODO: 10/08/2023
    @Override
    public void deleteBlog(long id) {

    }

    @Override
    public List<Blog> getBlogsByUserId(long id) {
        return blogDao.getBlogByUser(id);
    }
}

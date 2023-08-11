package com.example.travelblog.dao.impl;

import com.example.travelblog.dao.BlogDao;
import com.example.travelblog.models.Blog;
import com.example.travelblog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/*
 * @created 10/08/2023 - 12:56 PM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */

@RequiredArgsConstructor
@Component
public class BlogDaoImpl implements BlogDao {
    private final BlogRepository blogRepository;


    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog CreateBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(long id, Blog blog) {
        Blog oldBlog = this.getBlogById(id).orElseThrow();

        BeanUtils.copyProperties(blog, oldBlog, "id", "user");

        return blogRepository.save(oldBlog);
    }

    @Override
    public boolean deleteBlog(long id) {
        blogRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Blog> getBlogByUser(long id) {
        return blogRepository.getUserPosts(id);
    }

    @Override
    public Optional<Blog> getBlogById(long id) {
        return blogRepository.findById(id);
    }
}

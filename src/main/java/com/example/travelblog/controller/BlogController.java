package com.example.travelblog.controller;

/*
 * @created 10/08/2023 - 1:17 PM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */

import com.example.travelblog.controller.request.BlogRequest;
import com.example.travelblog.controller.response.MsgResponse;
import com.example.travelblog.models.Blog;
import com.example.travelblog.models.User;
import com.example.travelblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/blog")

@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @PostMapping()
    public Blog createBlog(@RequestBody BlogRequest postRequest, Authentication authentication) {
        System.out.println(authentication.getPrincipal());
        return blogService.createBlog(postRequest, (User) authentication.getPrincipal());
    }

    @PatchMapping("/{id}")
    public Blog updateUserData(@PathVariable(name = "id") Long id, @RequestBody BlogRequest postRequest, Authentication authentication) {
        return blogService.updateBlog(id, postRequest, (User) authentication.getPrincipal());
    }

    @DeleteMapping("/{id}")
    public MsgResponse delete(@PathVariable(name = "id") Long id, Authentication authentication) {
        System.out.println(authentication.getPrincipal());
        blogService.deleteBlog(id, (User) authentication.getPrincipal());
        return new MsgResponse("Blog deleted successfully", true);
    }

    @GetMapping("/user/{id}")
    public List<Blog> getUserPosts(@PathVariable(name = "id") Long id) {
        return blogService.getBlogsByUserId(id);
    }


    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable(name = "id") Long id) {
        return blogService.getBlogById(id);
    }

    @GetMapping()
    public List<Blog> getAllBlogs() {
        return blogService.getBlogs();
    }


}

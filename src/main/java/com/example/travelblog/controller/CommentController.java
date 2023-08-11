package com.example.travelblog.controller;

import com.example.travelblog.controller.request.CommentRequest;
import com.example.travelblog.models.Comment;
import com.example.travelblog.models.User;
import com.example.travelblog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @created 11/08/2023 - 7:43 PM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping()
    public Comment createComment(@RequestBody CommentRequest commentRequest, Authentication authentication) {
        return commentService.CreateComment(commentRequest, (User) authentication.getPrincipal());
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable(name = "id") Long id, Authentication authentication) {
        System.out.println(authentication.getPrincipal());
        commentService.deleteComment(id, (User) authentication.getPrincipal());
        return "deleted";
    }


    @PatchMapping("/{id}")
    public Comment updateUserData(@PathVariable(name = "id") Long id, @RequestBody CommentRequest commentRequest, Authentication authentication) {
        return commentService.updateComment(id, commentRequest, (User) authentication.getPrincipal());
    }


    @GetMapping("/post/{id}")
    public List<Comment> getUserComment(@PathVariable(name = "id") Long id) {
        return commentService.getCommentByPost(id);
    }

}

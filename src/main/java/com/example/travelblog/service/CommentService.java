package com.example.travelblog.service;

import com.example.travelblog.controller.request.CommentRequest;
import com.example.travelblog.models.Comment;
import com.example.travelblog.models.User;

import java.util.List;

/*
 * @created 11/08/2023 - 7:36 PM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
public interface CommentService {
    Comment CreateComment(CommentRequest commentRequest, User user);

    Comment updateComment(long id, CommentRequest  commentRequest, User user);

    boolean deleteComment(long id, User user);

    Comment getCommentById(long id);

    List<Comment> getCommentByPost(long id);

}

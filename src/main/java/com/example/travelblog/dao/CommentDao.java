package com.example.travelblog.dao;

import com.example.travelblog.models.Comment;

import java.util.List;

/*
 * @created 11/08/2023 - 7:24 PM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
public interface CommentDao {
    Comment CreateComment(Comment comment);

    Comment updateComment(long id, Comment comment);

    boolean deleteComment(long id);

    boolean deleteCommentByBlogId(long id);

    List<Comment> getCommentByPost(long id);

    Comment getCommentById(long id);

}


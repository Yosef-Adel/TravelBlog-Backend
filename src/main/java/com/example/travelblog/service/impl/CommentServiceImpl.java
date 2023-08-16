package com.example.travelblog.service.impl;

import com.example.travelblog.controller.request.CommentRequest;
import com.example.travelblog.dao.BlogDao;
import com.example.travelblog.dao.CommentDao;
import com.example.travelblog.exception.UnAuthrized;
import com.example.travelblog.models.Blog;
import com.example.travelblog.models.Comment;
import com.example.travelblog.models.User;
import com.example.travelblog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/*
 * @created 11/08/2023 - 7:39 PM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentDao commentDao;
    private final BlogDao blogDao;

    @Override
    public Comment CreateComment(CommentRequest commentRequest, User user) {
        System.out.println(commentRequest.getPostId());
        Blog blog = blogDao.getBlogById(commentRequest.getPostId()).orElseThrow();

        Comment comment = new Comment();
        comment.setBlog(blog);
        comment.setUser(user);
        comment.setText(commentRequest.getText());
        if (commentRequest.getCommentId() > 0) {
            Comment parentComment = commentDao.getCommentById(commentRequest.getCommentId());
            comment.setParentComment(parentComment);
        }
        commentDao.CreateComment(comment);

        return comment;
    }

    @Override
    public Comment updateComment(long id, CommentRequest commentRequest, User user) {
        Comment comment = commentDao.getCommentById(id);
        Blog blog = blogDao.getBlogById(commentRequest.getPostId()).orElseThrow();

        if (!Objects.equals(comment.getUser().getId(), user.getId())) {
            throw new UnAuthrized("you not authrized to delete the post");
        }
        Comment updatedComment = new Comment();
        updatedComment.setText(commentRequest.getText());
        updatedComment.setUser(user);
        updatedComment.setBlog(comment.getBlog());
        updatedComment.setId(comment.getId());

        return commentDao.updateComment(id, updatedComment);
    }


    @Override
    public boolean deleteComment(long id, User user) {
        Comment comment = commentDao.getCommentById(id);
        if (!Objects.equals(comment.getUser().getId(), user.getId()) && !user.isAdmin()) {
            throw new UnAuthrized("you not authrized to delete the post");
        }
        commentDao.deleteComment(id);
        return true;
    }

    @Override
    public Comment getCommentById(long id) {
        return commentDao.getCommentById(id);
    }

    @Override
    public List<Comment> getCommentByPost(long id) {
        return commentDao.getCommentByPost(id);
    }
}

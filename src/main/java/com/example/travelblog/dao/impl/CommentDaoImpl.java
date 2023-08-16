package com.example.travelblog.dao.impl;

import com.example.travelblog.dao.CommentDao;
import com.example.travelblog.models.Comment;
import com.example.travelblog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @created 11/08/2023 - 7:26 PM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
@RequiredArgsConstructor
@Repository
public class CommentDaoImpl implements CommentDao {
    private final CommentRepository commentReporsitory;
    @Override
    public Comment CreateComment(Comment comment) {
        return commentReporsitory.save(comment);
    }

    @Override
    public Comment updateComment(long id, Comment comment) {
        Comment oldComment = commentReporsitory.findById(id).orElseThrow();

        BeanUtils.copyProperties(comment, oldComment, "id", "user");
        return commentReporsitory.save(oldComment);
    }

    @Override
    public boolean deleteComment(long id) {
        commentReporsitory.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteCommentByBlogId(long id) {
        List<Comment> comments = commentReporsitory.findCommentByPostId(id);
        commentReporsitory.deleteAll(comments);
        return true;
    }

    @Override
    public List<Comment> getCommentByPost(long id) {
        return commentReporsitory.findCommentByPostId(id);
    }

    @Override
    public Comment getCommentById(long id) {
        return commentReporsitory.findById(id).orElseThrow();
    }
}

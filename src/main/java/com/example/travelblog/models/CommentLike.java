package com.example.travelblog.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/*
 * @created 10/08/2023 - 12:18 PM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
@Entity
@DiscriminatorValue("COMMENT")
public class CommentLike extends Like{
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;
}

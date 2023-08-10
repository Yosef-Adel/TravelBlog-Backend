package com.example.travelblog.models;

/*
 * @created 10/08/2023 - 11:46 AM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@Table(name = "Comment")
@ToString
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;
}

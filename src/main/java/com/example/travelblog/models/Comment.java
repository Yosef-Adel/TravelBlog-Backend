package com.example.travelblog.models;

/*
 * @created 10/08/2023 - 11:46 AM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@Table(name = "Comment")
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(name = "blog_id")
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;

    @Column(name = "created_at", nullable = true, updatable = false)
    private java.sql.Date createdAt;

    // @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at",  nullable = true)
    private java.sql.Date updatedAt;


}

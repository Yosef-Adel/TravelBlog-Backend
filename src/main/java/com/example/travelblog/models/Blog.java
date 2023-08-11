package com.example.travelblog.models;

/*
 * @created 10/08/2023 - 11:34 AM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Data
@Table(name = "blog")
@RequiredArgsConstructor
public class Blog {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "picture")
    private String picture;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;


    @OneToMany(mappedBy = "blog")
    private List<Comment> comments;

    @Column(name = "created_at", nullable = true, updatable = false)
    private java.sql.Date createdAt;

    // @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at",  nullable = true)
    private java.sql.Date updatedAt;


}

package com.example.travelblog.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/*
 * @created 10/08/2023 - 12:17 PM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
@Entity
@DiscriminatorValue("POST")
@Data
public class BlogLike extends Like{
    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;
}

package com.example.travelblog.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

/*
 * @created 10/08/2023 - 12:06 PM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
@Entity
@Data
@Table(name = "likes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "likable_type")
@ToString
@RequiredArgsConstructor
public class Like {
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

}

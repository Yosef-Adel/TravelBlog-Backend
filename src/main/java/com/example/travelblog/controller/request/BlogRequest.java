package com.example.travelblog.controller.request;

import lombok.*;

/*
 * @created 10/08/2023 - 1:20 PM
 * @project TravelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BlogRequest {

    private String content;
    private String title;
    private String   picture;

    public BlogRequest(String content, String title) {
        this.content = content;
        this.title = title;
        this.picture = null;
    }
}

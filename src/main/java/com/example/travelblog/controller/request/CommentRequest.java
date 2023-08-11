package com.example.travelblog.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CommentRequest {

    @NonNull
    String text;

    long PostId;
}

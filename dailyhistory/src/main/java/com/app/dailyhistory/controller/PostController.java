package com.app.dailyhistory.controller;

import com.app.dailyhistory.DTOS.PostDTO;
import com.app.dailyhistory.domain.post.Post;
import com.app.dailyhistory.service.post.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Post>createPost(@RequestBody PostDTO postDTO){

        Post newPost = postService.createAndSavePost(postDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPost);


    }



}

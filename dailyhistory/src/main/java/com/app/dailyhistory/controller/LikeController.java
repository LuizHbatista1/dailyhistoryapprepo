package com.app.dailyhistory.controller;

import com.app.dailyhistory.DTOS.LikeDTO;
import com.app.dailyhistory.repository.PostRepository;
import com.app.dailyhistory.service.like.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feed")
public class LikeController {

    private final LikeService likeService;
    private final PostRepository postRepository;

    public LikeController(LikeService likeService, PostRepository postRepository) {
        this.likeService = likeService;
        this.postRepository = postRepository;
    }

    @PostMapping
    public ResponseEntity<Integer> createLike(@RequestBody LikeDTO likeDTO) {


        Integer createLike = likeService.actualizeNumberOfLikes(likeDTO.postId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createLike);

    }

}

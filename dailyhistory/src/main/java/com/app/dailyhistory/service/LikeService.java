package com.app.dailyhistory.service;

import com.app.dailyhistory.DTOS.LikeDTO;
import com.app.dailyhistory.domain.Like;
import com.app.dailyhistory.domain.Post;
import com.app.dailyhistory.repository.LikeRepository;
import com.app.dailyhistory.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeService implements LikeServiceInterface {

    private final LikeRepository likeRepository;
    private final PostService postService;
    private final PostRepository postRepository;

    public LikeService(LikeRepository likeRepository, PostService postService, PostRepository postRepository) {
        this.likeRepository = likeRepository;
        this.postService = postService;
        this.postRepository = postRepository;
    }


    @Override
    public Like createAndSaveLike(LikeDTO likeDTO) {

        Post targetPost = postService.searchPostById(likeDTO.postId());
        Like newLike = new Like();
        newLike.setPostId(targetPost);
        this.likeRepository.save(newLike);
        return newLike;
    }

    @Override
    public Integer actualizeNumberOfLikes(Long id) {

        Post targetPost = postService.searchPostById(id);
        Integer getNumberLikes = targetPost.getNumberOfLikes();
        Integer currentNumberLikes = getNumberLikes + 1;
        targetPost.setNumberOfLikes(currentNumberLikes);
        postRepository.save(targetPost);
        return currentNumberLikes;

    }
}

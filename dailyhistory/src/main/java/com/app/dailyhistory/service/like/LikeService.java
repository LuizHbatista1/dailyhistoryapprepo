package com.app.dailyhistory.service.like;

import com.app.dailyhistory.DTOS.LikeDTO;
import com.app.dailyhistory.domain.like.Like;
import com.app.dailyhistory.domain.post.Post;
import com.app.dailyhistory.repository.LikeRepository;
import com.app.dailyhistory.repository.PostRepository;
import com.app.dailyhistory.service.post.PostService;
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

        Post targetPost = postService.findPostById(likeDTO.postId());
        Like newLike = new Like();
        newLike.setPostId(targetPost);
        this.likeRepository.save(newLike);
        return newLike;
    }

    @Override
    public Integer actualizeNumberOfLikes(Long id) {

        Post targetPost = postService.findPostById(id);
        Integer getNumberLikes = targetPost.getNumberOfLikes();
        Integer currentNumberLikes = getNumberLikes + 1;
        targetPost.setNumberOfLikes(currentNumberLikes);
        postRepository.save(targetPost);
        return currentNumberLikes;

    }
}

package com.app.dailyhistory.service;

import com.app.dailyhistory.DTOS.StarryDTO;
import com.app.dailyhistory.domain.post.Post;
import com.app.dailyhistory.domain.starry.Starry;
import com.app.dailyhistory.repository.StarryRepository;
import com.app.dailyhistory.service.post.PostService;
import org.springframework.stereotype.Service;

@Service
public class StarryService implements StarryServiceInterface {

    private final StarryRepository starryRepository;
    private final PostService postService;

    public StarryService(StarryRepository starryRepository, PostService postService) {
        this.starryRepository = starryRepository;
        this.postService = postService;
    }

    @Override
    public Starry createAndSaveStarryPost(StarryDTO starryDTO) {
        Post targetPost = postService.searchPostById(starryDTO.postId());
        Starry newStarry = new Starry(starryDTO);
        newStarry.setPostId(targetPost);
        this.starryRepository.save(newStarry);
        return newStarry;

    }



}

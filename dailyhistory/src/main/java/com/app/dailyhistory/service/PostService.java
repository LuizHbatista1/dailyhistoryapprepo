package com.app.dailyhistory.service;

import com.app.dailyhistory.DTOS.LikeDTO;
import com.app.dailyhistory.DTOS.PostDTO;
import com.app.dailyhistory.domain.Post;
import com.app.dailyhistory.repository.LikeRepository;
import com.app.dailyhistory.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService implements PostServiceInterface {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post searchPostById(Long id) {
       return this.postRepository.findById(id).orElseThrow(()-> new RuntimeException());
    }

    @Override
    public Post createAndSavePost(PostDTO postDTO) {

        Post newPost = new Post(postDTO);
        newPost.setTitle(postDTO.title());
        newPost.setDescription(postDTO.description());
        newPost.setNumberOfLikes(postDTO.numberOfLikes());
        newPost.setTagType(postDTO.tagType());
        this.postRepository.save(newPost);
        return newPost;

    }

    @Override
    public void searchPostByTag() {

    }
}



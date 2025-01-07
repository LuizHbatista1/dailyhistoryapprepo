package com.app.dailyhistory.service.post;

import com.app.dailyhistory.DTOS.PostDTO;
import com.app.dailyhistory.domain.post.Post;
import com.app.dailyhistory.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Service
public class PostService implements PostServiceInterface {

    private final PostRepository postRepository;
    private final Logger logger = LoggerFactory.getLogger(PostService.class);

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post findPostById(Long id) {
        try {

            return this.postRepository.findById(id).orElseThrow(RuntimeException::new);

        } catch (RuntimeException exception) {

            logger.error("Error occurred while finding post with ID {}: {}", id, exception.getMessage(), exception);
            throw new RuntimeException();
        }
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



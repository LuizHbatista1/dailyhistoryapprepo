package com.app.dailyhistory.service.post;

import com.app.dailyhistory.DTOS.PostDTO;
import com.app.dailyhistory.domain.post.Post;

import java.util.Optional;

public interface PostServiceInterface {

    Post findPostById(Long id);
    Post createAndSavePost(PostDTO postDTO);
    void searchPostByTag();


}

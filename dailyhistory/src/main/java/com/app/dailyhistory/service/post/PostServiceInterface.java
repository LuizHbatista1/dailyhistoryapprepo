package com.app.dailyhistory.service.post;

import com.app.dailyhistory.DTOS.PostDTO;
import com.app.dailyhistory.domain.post.Post;

public interface PostServiceInterface {

    Post searchPostById(Long id);
    Post createAndSavePost(PostDTO postDTO);
    void searchPostByTag();


}

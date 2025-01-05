package com.app.dailyhistory.service;

import com.app.dailyhistory.DTOS.LikeDTO;
import com.app.dailyhistory.DTOS.PostDTO;
import com.app.dailyhistory.domain.Post;

public interface PostServiceInterface {

    Post searchPostById(Long id);
    Post createAndSavePost(PostDTO postDTO);
    void searchPostByTag();


}

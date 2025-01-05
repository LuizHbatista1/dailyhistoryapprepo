package com.app.dailyhistory.service;

import com.app.dailyhistory.DTOS.LikeDTO;
import com.app.dailyhistory.DTOS.PostDTO;
import com.app.dailyhistory.domain.Like;
import com.app.dailyhistory.domain.Post;

public interface LikeServiceInterface {

    Like createAndSaveLike(LikeDTO likeDTO);
    Integer actualizeNumberOfLikes(Long id);

}

package com.app.dailyhistory.service.like;

import com.app.dailyhistory.DTOS.LikeDTO;
import com.app.dailyhistory.domain.like.Like;

public interface LikeServiceInterface {

    Like createAndSaveLike(LikeDTO likeDTO);
    Integer actualizeNumberOfLikes(Long id);

}

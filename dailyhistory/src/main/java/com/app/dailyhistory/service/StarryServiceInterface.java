package com.app.dailyhistory.service;

import com.app.dailyhistory.DTOS.StarryDTO;
import com.app.dailyhistory.domain.starry.Starry;

public interface StarryServiceInterface {

    Starry createAndSaveStarryPost(StarryDTO starryDTO);


}

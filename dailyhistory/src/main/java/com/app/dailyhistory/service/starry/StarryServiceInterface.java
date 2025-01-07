package com.app.dailyhistory.service.starry;

import com.app.dailyhistory.DTOS.StarryDTO;
import com.app.dailyhistory.domain.starry.Starry;

public interface StarryServiceInterface {

    Starry createAndSaveStarryPost(StarryDTO starryDTO);


}

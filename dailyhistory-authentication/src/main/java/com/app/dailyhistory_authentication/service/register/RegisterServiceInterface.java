package com.app.dailyhistory_authentication.service.register;

import com.app.dailyhistory_authentication.DTOS.RegisterUserDTO;
import com.app.dailyhistory_authentication.domain.User;

public interface RegisterServiceInterface {


    User createAndSaveUser(RegisterUserDTO registerUserDTO);

    void checkPasswordEqualsAndLength(RegisterUserDTO registerUserDTO);

}

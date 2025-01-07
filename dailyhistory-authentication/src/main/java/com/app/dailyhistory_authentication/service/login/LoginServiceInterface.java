package com.app.dailyhistory_authentication.service.login;

import com.app.dailyhistory_authentication.DTOS.LoginRequestDTO;
import com.app.dailyhistory_authentication.DTOS.LoginResponseDTO;
import com.app.dailyhistory_authentication.domain.User;

public interface LoginServiceInterface {

    LoginResponseDTO makeLogin(LoginRequestDTO loginRequestDTO);


}

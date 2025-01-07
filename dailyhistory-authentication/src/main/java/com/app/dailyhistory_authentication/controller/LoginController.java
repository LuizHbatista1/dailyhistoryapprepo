package com.app.dailyhistory_authentication.controller;

import com.app.dailyhistory_authentication.DTOS.LoginRequestDTO;
import com.app.dailyhistory_authentication.DTOS.LoginResponseDTO;
import com.app.dailyhistory_authentication.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<LoginResponseDTO>login(@RequestBody LoginRequestDTO loginRequestDTO){

        LoginResponseDTO login = loginService.makeLogin(loginRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(login);

    }


}

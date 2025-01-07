package com.app.dailyhistory_authentication.controller;

import com.app.dailyhistory_authentication.DTOS.RegisterUserDTO;
import com.app.dailyhistory_authentication.domain.User;
import com.app.dailyhistory_authentication.service.register.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public ResponseEntity<User>createUser(@RequestBody RegisterUserDTO registerUserDTO){

        User newUser =  registerService.createAndSaveUser(registerUserDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);

    }

}

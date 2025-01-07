package com.app.dailyhistory.controller;

import com.app.dailyhistory.DTOS.StarryDTO;
import com.app.dailyhistory.domain.starry.Starry;
import com.app.dailyhistory.service.starry.StarryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/starry")
public class StarryController {

    private final StarryService starryService;

    public StarryController(StarryService starryService) {
        this.starryService = starryService;
    }

    @PostMapping
    public ResponseEntity<Starry>createStarry(@RequestBody StarryDTO starryDTO){

        Starry newStarry = starryService.createAndSaveStarryPost(starryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStarry);

    }

}

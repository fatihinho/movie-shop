package com.fcinar.movieshop.controller;

import com.fcinar.movieshop.dto.AddDirectorRequest;
import com.fcinar.movieshop.model.Director;
import com.fcinar.movieshop.service.DirectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/director")
public class DirectorController {
    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @PostMapping
    public ResponseEntity<Director> addDirector(@RequestBody AddDirectorRequest addDirectorRequest) {
        return ResponseEntity.ok(directorService.addDirector(addDirectorRequest));
    }
}

package com.fcinar.movieshop.controller;

import com.fcinar.movieshop.dto.AddDirectorRequest;
import com.fcinar.movieshop.dto.DirectorDto;
import com.fcinar.movieshop.model.Director;
import com.fcinar.movieshop.service.DirectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/director")
public class DirectorController {
    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DirectorDto>> getAllMovies() {
        return ResponseEntity.ok(directorService.getAllDirectors());
    }

    @PostMapping
    public ResponseEntity<Director> addDirector(@RequestBody AddDirectorRequest addDirectorRequest) {
        return ResponseEntity.ok(directorService.addDirector(addDirectorRequest));
    }
}

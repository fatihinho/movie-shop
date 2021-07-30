package com.fcinar.movieshop.controller;

import com.fcinar.movieshop.dto.AddDirectorRequest;
import com.fcinar.movieshop.dto.DirectorDto;
import com.fcinar.movieshop.model.Director;
import com.fcinar.movieshop.service.DirectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/directors")
public class DirectorController {
    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public ResponseEntity<List<DirectorDto>> getAllMovies() {
        return ResponseEntity.ok(directorService.getAllDirectors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectorDto> getDirectorById(@PathVariable UUID id) {
        return ResponseEntity.ok(directorService.getDirectorById(id));
    }

    @GetMapping("/name")
    public ResponseEntity<List<DirectorDto>> filterDirectorsByName(@RequestParam String p) {
        return ResponseEntity.ok(directorService.filterDirectorsByName(p));
    }

    @GetMapping("/surname")
    public ResponseEntity<List<DirectorDto>> filterDirectorsBySurname(@RequestParam String p) {
        return ResponseEntity.ok(directorService.filterDirectorsBySurname(p));
    }

    @PostMapping
    public ResponseEntity<Director> addDirector(@RequestBody AddDirectorRequest addDirectorRequest) {
        return ResponseEntity.ok(directorService.addDirector(addDirectorRequest));
    }
}

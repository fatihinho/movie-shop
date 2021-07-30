package com.fcinar.movieshop.controller;

import com.fcinar.movieshop.dto.AddMovieRequest;
import com.fcinar.movieshop.dto.MovieDto;
import com.fcinar.movieshop.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable UUID id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping("/name")
    public ResponseEntity<List<MovieDto>> filterMoviesByName(@RequestParam String p) {
        return ResponseEntity.ok(movieService.filterMoviesByName(p));
    }

    @PostMapping
    public ResponseEntity<MovieDto> addMovie(@RequestBody AddMovieRequest addMovieRequest) {
        return ResponseEntity.ok(movieService.addMovie(addMovieRequest));
    }
}

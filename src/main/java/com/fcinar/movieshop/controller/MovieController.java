package com.fcinar.movieshop.controller;

import com.fcinar.movieshop.dto.AddMovieRequest;
import com.fcinar.movieshop.dto.MovieDto;
import com.fcinar.movieshop.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @PostMapping
    public ResponseEntity<MovieDto> addMovie(@RequestBody AddMovieRequest addMovieRequest) {
        return ResponseEntity.ok(movieService.addMovie(addMovieRequest));
    }
}

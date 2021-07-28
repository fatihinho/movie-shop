package com.fcinar.movieshop.controller;

import com.fcinar.movieshop.dto.AddMovieRequest;
import com.fcinar.movieshop.model.Movie;
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
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody AddMovieRequest addMovieRequest) {
        return ResponseEntity.ok(movieService.addMovie(addMovieRequest));
    }
}

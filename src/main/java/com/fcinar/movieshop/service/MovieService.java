package com.fcinar.movieshop.service;

import com.fcinar.movieshop.dto.AddMovieRequest;
import com.fcinar.movieshop.model.Movie;
import com.fcinar.movieshop.repository.IMovieRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final IMovieRepository movieRepository;

    public MovieService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(@NotNull AddMovieRequest addMovieRequest) {
        Movie movie = new Movie(addMovieRequest.getName(), addMovieRequest.getRank());
        return movieRepository.save(movie);
    }
}

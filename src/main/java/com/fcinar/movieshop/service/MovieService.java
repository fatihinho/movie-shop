package com.fcinar.movieshop.service;

import com.fcinar.movieshop.dto.AddMovieRequest;
import com.fcinar.movieshop.dto.MovieDto;
import com.fcinar.movieshop.dto.converter.MovieDtoConverter;
import com.fcinar.movieshop.model.Movie;
import com.fcinar.movieshop.repository.IMovieRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final IMovieRepository movieRepository;
    private final MovieDtoConverter converter;

    public MovieService(IMovieRepository movieRepository, MovieDtoConverter converter) {
        this.movieRepository = movieRepository;
        this.converter = converter;
    }

    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll().stream().map(converter::convert).collect(Collectors.toList());
    }

    public MovieDto addMovie(@NotNull AddMovieRequest addMovieRequest) {
        Movie movie = new Movie(addMovieRequest.getName(), addMovieRequest.getRank());
        return converter.convert(movieRepository.save(movie));
    }
}

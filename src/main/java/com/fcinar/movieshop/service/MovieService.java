package com.fcinar.movieshop.service;

import com.fcinar.movieshop.dto.AddMovieRequest;
import com.fcinar.movieshop.dto.MovieDto;
import com.fcinar.movieshop.dto.converter.MovieDtoConverter;
import com.fcinar.movieshop.model.Director;
import com.fcinar.movieshop.model.Movie;
import com.fcinar.movieshop.repository.IMovieRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final DirectorService directorService;
    private final IMovieRepository movieRepository;
    private final MovieDtoConverter converter;

    public MovieService(DirectorService directorService, IMovieRepository movieRepository, MovieDtoConverter converter) {
        this.directorService = directorService;
        this.movieRepository = movieRepository;
        this.converter = converter;
    }

    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll().stream().map(converter::convert).collect(Collectors.toList());
    }

    public MovieDto addMovie(@NotNull AddMovieRequest addMovieRequest) {
        Director director = directorService.findById(addMovieRequest.getDirectorId());
        Movie movie = new Movie(addMovieRequest.getName(), addMovieRequest.getRank(), director);
        return converter.convert(movieRepository.save(movie));
    }
}

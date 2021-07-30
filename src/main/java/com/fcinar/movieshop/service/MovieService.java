package com.fcinar.movieshop.service;

import com.fcinar.movieshop.dto.AddMovieRequest;
import com.fcinar.movieshop.dto.MovieDto;
import com.fcinar.movieshop.dto.converter.MovieDtoConverter;
import com.fcinar.movieshop.exception.MovieNotFoundException;
import com.fcinar.movieshop.model.Director;
import com.fcinar.movieshop.model.Movie;
import com.fcinar.movieshop.repository.IMovieRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final DirectorService directorService;
    private final IMovieRepository movieRepository;
    private final MovieDtoConverter movieDtoConverter;

    public MovieService(DirectorService directorService,
                        IMovieRepository movieRepository, MovieDtoConverter movieDtoConverter) {
        this.directorService = directorService;
        this.movieRepository = movieRepository;
        this.movieDtoConverter = movieDtoConverter;
    }

    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll().stream().map(movieDtoConverter::convert).collect(Collectors.toList());
    }

    public MovieDto addMovie(@NotNull AddMovieRequest addMovieRequest) {
        Director director = directorService.findById(addMovieRequest.getDirectorId());
        Movie movie = new Movie(addMovieRequest.getName(), addMovieRequest.getRank(), director);
        return movieDtoConverter.convert(movieRepository.save(movie));
    }

    public MovieDto getMovieById(UUID id) {
        Movie movie = movieRepository
                .findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie could not found by id: " + id));
        return movieDtoConverter.convert(movie);
    }

    public List<MovieDto> filterMoviesByName(String name) {
        return movieRepository.findAllByNameIgnoreCase(name)
                .stream().map(movieDtoConverter::convert).collect(Collectors.toList());
    }
}

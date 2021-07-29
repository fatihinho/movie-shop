package com.fcinar.movieshop.dto.converter;

import com.fcinar.movieshop.dto.MovieDto;
import com.fcinar.movieshop.model.Movie;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MovieDtoConverter {
    public MovieDto convert(@NotNull Movie from) {
        return new MovieDto(from.getId(), from.getName(), from.getRank(), Objects.requireNonNull(from.getDirector()));
    }
}

package com.fcinar.movieshop.dto.converter;

import com.fcinar.movieshop.dto.DirectorDto;
import com.fcinar.movieshop.model.Director;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class DirectorDtoConverter {
    public DirectorDto convert(@NotNull Director from) {
        return new DirectorDto(from.getId(), from.getName(), from.getSurname());
    }
}

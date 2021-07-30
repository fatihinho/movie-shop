package com.fcinar.movieshop.service;

import com.fcinar.movieshop.dto.AddDirectorRequest;
import com.fcinar.movieshop.dto.DirectorDto;
import com.fcinar.movieshop.dto.converter.DirectorDtoConverter;
import com.fcinar.movieshop.exception.DirectorNotFoundException;
import com.fcinar.movieshop.model.Director;
import com.fcinar.movieshop.repository.IDirectorRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DirectorService {
    private final IDirectorRepository directorRepository;
    private final DirectorDtoConverter directorDtoConverter;

    public DirectorService(IDirectorRepository directorRepository, DirectorDtoConverter directorDtoConverter) {
        this.directorRepository = directorRepository;
        this.directorDtoConverter = directorDtoConverter;
    }

    public List<DirectorDto> getAllDirectors() {
        return directorRepository.findAll().stream().map(directorDtoConverter::convert).collect(Collectors.toList());
    }

    public Director addDirector(@NotNull AddDirectorRequest addDirectorRequest) {
        Director director = new Director(addDirectorRequest.getName(), addDirectorRequest.getSurname());
        return directorRepository.save(director);
    }

    protected Director findById(UUID id) {
        return directorRepository
                .findById(id)
                .orElseThrow(() -> new DirectorNotFoundException("Director could not find by id: " + id));
    }

    public DirectorDto getDirectorById(UUID id) {
        Director director = findById(id);
        return directorDtoConverter.convert(director);
    }

    public List<DirectorDto> filterDirectorsByName(String name) {
        return directorRepository.findAllByNameIgnoreCase(name)
                .stream().map(directorDtoConverter::convert).collect(Collectors.toList());
    }

    public List<DirectorDto> filterDirectorsBySurname(String surname) {
        return directorRepository.findAllBySurnameIgnoreCase(surname)
                .stream().map(directorDtoConverter::convert).collect(Collectors.toList());
    }
}

package com.fcinar.movieshop.service;

import com.fcinar.movieshop.dto.AddDirectorRequest;
import com.fcinar.movieshop.model.Director;
import com.fcinar.movieshop.repository.IDirectorRepository;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {
    private final IDirectorRepository directorRepository;

    public DirectorService(IDirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public Director addDirector(AddDirectorRequest addDirectorRequest) {
        Director director = new Director(addDirectorRequest.getName(), addDirectorRequest.getSurname());
        return directorRepository.save(director);
    }
}

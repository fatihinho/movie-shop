package com.fcinar.movieshop.repository;

import com.fcinar.movieshop.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, UUID> {
    List<Movie> findAllByNameIgnoreCase(String name);
}

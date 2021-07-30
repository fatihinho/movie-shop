package com.fcinar.movieshop.repository;

import com.fcinar.movieshop.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IDirectorRepository extends JpaRepository<Director, UUID> {
    List<Director> findAllByNameIgnoreCase(String name);

    List<Director> findAllBySurnameIgnoreCase(String surname);
}

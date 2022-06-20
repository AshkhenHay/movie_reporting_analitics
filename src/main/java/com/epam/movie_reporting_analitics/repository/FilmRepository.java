package com.epam.movie_reporting_analitics.repository;


import com.epam.movie_reporting_analitics.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    Optional<Film> findById(Long id);
}

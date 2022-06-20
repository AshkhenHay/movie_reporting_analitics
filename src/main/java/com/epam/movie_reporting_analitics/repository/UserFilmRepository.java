package com.epam.movie_reporting_analitics.repository;


import com.epam.movie_reporting_analitics.model.User;
import com.epam.movie_reporting_analitics.model.UserFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserFilmRepository extends JpaRepository<UserFilm, Long> {
     @Query(value = "SELECT * FROM user_film  WHERE user_id=:id",nativeQuery = true)
     Set<UserFilm> findByUser(long id);
     @Query(value = "SELECT * FROM user_film  WHERE film_id=:id",nativeQuery = true)
     Set<UserFilm> findByFilm(long id);
}

package com.epam.movie_reporting_analitics.service;

import com.epam.movie_reporting_analitics.config.mapper.userFilmMapper.UserFilmResponseMapper;
import com.epam.movie_reporting_analitics.dto.UserFilmResponseDTO;
import com.epam.movie_reporting_analitics.model.Film;
import com.epam.movie_reporting_analitics.model.UserFilm;
import com.epam.movie_reporting_analitics.repository.FilmRepository;
import com.epam.movie_reporting_analitics.repository.UserFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserFilmService {

    private final UserFilmRepository userFilmRepository;
    private final FilmRepository filmRepository;
    private final UserFilmResponseMapper userFilmResponseMapper;

    @Autowired
    public UserFilmService(UserFilmRepository userFilmRepository, UserFilmResponseMapper userFilmResponseMapper, FilmRepository filmRepository) {
        this.userFilmRepository = userFilmRepository;
        this.userFilmResponseMapper = userFilmResponseMapper;
        this.filmRepository = filmRepository;
    }

    public List<UserFilmResponseDTO> getAll() {
        List<UserFilm> userFilms = userFilmRepository.findAll();
        return userFilms
                .stream()
                .map(userFilm -> userFilmResponseMapper.mapToDTO(userFilm))
                .collect(Collectors.toList());

    }

    public List<UserFilmResponseDTO> getByUserId(long userId) {
        List<UserFilm> userFilms = new ArrayList<>();
        Set<UserFilm> existingUserFilm = userFilmRepository.findByUser(userId);
        for (UserFilm userFilm : existingUserFilm) {
            userFilms.add(userFilm);
        }
        return userFilms
                .stream()
                .map(userFilm -> userFilmResponseMapper.mapToDTO(userFilm))
                .collect(Collectors.toList());
    }

    public int getRateAverage(Long filmId) {
        int rateAverage = 0;
        int index = 0;
        Set<UserFilm> existingUserFilms = userFilmRepository.findByFilm(filmId);
        for (UserFilm userFilm : existingUserFilms) {
            int rate = userFilm.getRate();
            rateAverage += rate;
            index++;
        }
        int rate = rateAverage / index;
        Film film = filmRepository.findById(filmId).get();
        film.setRateAverage(rate);
        return rate;
    }

    public int filmsNumberOfViews(Long filmId) {
        int quantity = 0;
        Set<UserFilm> existingUserFilms = userFilmRepository.findByFilm(filmId);
        for (UserFilm userFilm : existingUserFilms) {
            userFilm.getUser();
            quantity++;
        }
        return quantity;
    }
}
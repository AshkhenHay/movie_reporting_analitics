package com.epam.movie_reporting_analitics.endpoint;

import com.epam.movie_reporting_analitics.dto.UserFilmResponseDTO;
import com.epam.movie_reporting_analitics.service.UserFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userFilm")
public class UserFilmController {

    private final UserFilmService userFilmService;

    @Autowired
    public UserFilmController(UserFilmService userFilmService) {
        this.userFilmService = userFilmService;
    }

    @GetMapping("/")
    public List<UserFilmResponseDTO> getAllUserFilm() {
        return userFilmService.getAll();
    }

    @GetMapping("/{userId}")
    public List<UserFilmResponseDTO> getByUser(@PathVariable("userId") long userId) {
        return userFilmService.getByUserId(userId);
    }

    @GetMapping("/rate/{filmId}")
    public int getRate(@PathVariable("filmId") long filmId) {
        return userFilmService.getRateAverage(filmId);
    }

    @GetMapping("/film/{filmId}")
    public int filmsNumberOfViews(@PathVariable("filmId") long filmId) {
        return userFilmService.filmsNumberOfViews(filmId);
    }
}

package com.epam.movie_reporting_analitics.endpoint;

import com.epam.movie_reporting_analitics.dto.FilmResponseDTO;
import com.epam.movie_reporting_analitics.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/film")
@AllArgsConstructor
public class FilmController {


    private final FilmService filmService;


    @GetMapping("")
    public List<FilmResponseDTO> getAllFilms() {
        return filmService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getFilmById(@PathVariable("id") long id) {
        return ResponseEntity.ok(filmService.getById(id));
    }

}

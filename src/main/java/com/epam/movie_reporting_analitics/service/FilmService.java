package com.epam.movie_reporting_analitics.service;

import com.epam.movie_reporting_analitics.config.mapper.filmMapper.FilmResponseMapper;
import com.epam.movie_reporting_analitics.dto.FilmResponseDTO;
import com.epam.movie_reporting_analitics.exeption.NotFoundException;
import com.epam.movie_reporting_analitics.model.Film;
import com.epam.movie_reporting_analitics.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmService implements GenericService<FilmResponseDTO> {
    private final FilmRepository filmRepository;
    private final FilmResponseMapper filmResponseMapper;

    @Autowired
    public FilmService(FilmRepository filmRepository, FilmResponseMapper filmResponseMapper) {
        this.filmRepository = filmRepository;
        this.filmResponseMapper = filmResponseMapper;
    }

    public List<FilmResponseDTO> getAll() {
        List<Film> allFilms = filmRepository.findAll();
        return allFilms
                .stream()
                .map(film -> filmResponseMapper.mapToDTO(film))
                .collect(Collectors.toList());
    }

    public FilmResponseDTO getById(Long id) {
        Optional<Film> existingFilm = filmRepository.findById(id);
        if (!existingFilm.isEmpty()) {
            return filmResponseMapper.mapToDTO(existingFilm.get());
        } else {
            throw new NotFoundException("Film not found");
        }
    }
}

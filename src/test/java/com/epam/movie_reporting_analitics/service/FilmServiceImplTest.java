package com.epam.movie_reporting_analitics.service;


import com.epam.movie_reporting_analitics.config.mapper.filmMapper.FilmRequestMapper;
import com.epam.movie_reporting_analitics.config.mapper.filmMapper.FilmResponseMapper;
import com.epam.movie_reporting_analitics.dto.FilmRequestDTO;
import com.epam.movie_reporting_analitics.dto.FilmResponseDTO;
import com.epam.movie_reporting_analitics.exeption.NotFoundException;
import com.epam.movie_reporting_analitics.model.Film;
import com.epam.movie_reporting_analitics.repository.FilmRepository;
import com.epam.movie_reporting_analitics.util.FilmTestHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


public class FilmServiceImplTest extends FilmTestHelper {


    FilmRepository filmRepository = Mockito.mock(FilmRepository.class);

    FilmRequestMapper requestMapper = Mockito.mock(FilmRequestMapper.class);
    FilmResponseMapper responseMapper = Mockito.mock(FilmResponseMapper.class);

    private FilmService filmService;

    private Film film;
    private FilmResponseDTO responseDto;


    @BeforeEach
    void setUp() {
        filmService = new FilmService(filmRepository, responseMapper);
        responseDto = generateFilmResponseDTO();
        film = generateFilm();
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void getAllTest() {
        when(filmRepository.findAll()).thenReturn(List.of(film));
        when(responseMapper.mapToDTO(any(Film.class))).thenReturn(responseDto);
        filmService.getAll();
        verify(filmRepository, times(1)).findAll();
    }


    @Test
    void getByIdTest() {
        when(filmRepository.findById(any(Long.class))).thenReturn(Optional.of(film));
        when(responseMapper.mapToDTO(any(Film.class))).thenReturn(responseDto);

        FilmResponseDTO byId = filmService.getById(1L);

        verify(filmRepository, times(1)).findById(any(Long.class));
    }


    @Test
    public void notFoundExceptionTest() {
        when(filmRepository.findById(anyLong())).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, () -> filmService.getById(anyLong()));
    }

}

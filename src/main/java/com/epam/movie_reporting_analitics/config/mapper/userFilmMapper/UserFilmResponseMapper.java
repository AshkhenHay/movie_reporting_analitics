package com.epam.movie_reporting_analitics.config.mapper.userFilmMapper;


import com.epam.movie_reporting_analitics.config.mapper.BaseMapper;
import com.epam.movie_reporting_analitics.dto.FilmResponseDTO;
import com.epam.movie_reporting_analitics.dto.UserFilmResponseDTO;
import com.epam.movie_reporting_analitics.model.Film;
import com.epam.movie_reporting_analitics.model.UserFilm;
import org.springframework.stereotype.Component;

@Component
public class UserFilmResponseMapper implements BaseMapper<UserFilm, UserFilmResponseDTO> {
    @Override
    public UserFilmResponseDTO mapToDTO(UserFilm userFilm) {
        return UserFilmResponseDTO.builder()
                .id(userFilm.getId())
                .rate(userFilm.getRate())
                .film(userFilm.getFilm())
                .user(userFilm.getUser())
                .build();
    }

    @Override
    public UserFilm mapToEntity(UserFilmResponseDTO userFilmResponseDTO) {
        return UserFilm.builder()
                .id(userFilmResponseDTO.getId())
                .rate(userFilmResponseDTO.getRate())
                .film(userFilmResponseDTO.getFilm())
                .user(userFilmResponseDTO.getUser())
                .build();
    }
}

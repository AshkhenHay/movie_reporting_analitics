package com.epam.movie_reporting_analitics.config.mapper.userFilmMapper;


import com.epam.movie_reporting_analitics.config.mapper.BaseMapper;
import com.epam.movie_reporting_analitics.dto.UserFilmRequestDTO;
import com.epam.movie_reporting_analitics.model.UserFilm;
import org.springframework.stereotype.Component;

@Component
public class UserFilmRequestMapper implements BaseMapper<UserFilm, UserFilmRequestDTO> {
    @Override
    public UserFilmRequestDTO mapToDTO(UserFilm userFilm) {
        return UserFilmRequestDTO.builder()
                .rate(userFilm.getRate())
                .film(userFilm.getFilm())
                .user(userFilm.getUser())
                .build();
    }

    @Override
    public UserFilm mapToEntity(UserFilmRequestDTO userFilmRequestDTO) {
        return UserFilm.builder()
                .rate(userFilmRequestDTO.getRate())
                .film(userFilmRequestDTO.getFilm())
                .user(userFilmRequestDTO.getUser())
                .build();
    }
}

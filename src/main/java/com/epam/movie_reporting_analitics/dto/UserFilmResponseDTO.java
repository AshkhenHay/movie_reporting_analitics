package com.epam.movie_reporting_analitics.dto;

import com.epam.movie_reporting_analitics.model.Film;
import com.epam.movie_reporting_analitics.model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFilmResponseDTO {
    private long id;
    private int rate;
    private User user;
    private Film film;
}

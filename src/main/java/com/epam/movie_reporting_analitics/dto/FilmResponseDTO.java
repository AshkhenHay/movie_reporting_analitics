package com.epam.movie_reporting_analitics.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilmResponseDTO {
    private long id;
    private String name;
    private int ageRestriction;
    private int rateAverage;
}

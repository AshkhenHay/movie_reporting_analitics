package com.epam.movie_reporting_analitics.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilmRequestDTO {
    private String name;
    private int ageRestriction;
    private int rateAverage;
}

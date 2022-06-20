package com.epam.movie_reporting_analitics.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDTO {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
}

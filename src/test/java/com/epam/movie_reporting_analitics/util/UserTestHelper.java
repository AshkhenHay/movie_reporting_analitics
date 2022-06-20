package com.epam.movie_reporting_analitics.util;


import com.epam.movie_reporting_analitics.dto.UserRequestDTO;
import com.epam.movie_reporting_analitics.dto.UserResponseDTO;
import com.epam.movie_reporting_analitics.model.User;

public class UserTestHelper {


    protected static UserRequestDTO generateUserRequestDTO() {
        return UserRequestDTO.builder()
                .firstName("test_firstName")
                .lastName("test_lastName")
                .age(18)
                .email("test_email@gmail.com")
                .password("test_password")
                .build();
    }

    protected static UserResponseDTO generateUserResponseDTO() {
        return UserResponseDTO.builder()
                .id(1L)
                .firstName("test_firstName")
                .lastName("test_lastName")
                .age(18)
                .email("test_email@gmail.com")
                .build();
    }


    protected static User generateUser() {
        return User.builder()
                .id(1L)
                .firstName("test_firstName")
                .lastName("test_lastName")
                .age(18)
                .email("test_email@gmail.com")
                .password("test_password")
                .build();
    }

}


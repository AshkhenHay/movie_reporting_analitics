package com.epam.movie_reporting_analitics.service;


import com.epam.movie_reporting_analitics.config.mapper.userMapper.UserRequestMapper;
import com.epam.movie_reporting_analitics.config.mapper.userMapper.UserResponseMapper;
import com.epam.movie_reporting_analitics.dto.UserRequestDTO;
import com.epam.movie_reporting_analitics.dto.UserResponseDTO;
import com.epam.movie_reporting_analitics.exeption.NotFoundException;
import com.epam.movie_reporting_analitics.model.User;
import com.epam.movie_reporting_analitics.repository.UserRepository;
import com.epam.movie_reporting_analitics.util.UserTestHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplUserTest extends UserTestHelper {

    UserRepository userRepository = Mockito.mock(UserRepository.class);
    UserRequestMapper requestMapper = Mockito.mock(UserRequestMapper.class);
    UserResponseMapper responseMapper = Mockito.mock(UserResponseMapper.class);

    private UserService userService;

    private User user;
    private UserResponseDTO responseDto;


    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository,responseMapper);
        responseDto = generateUserResponseDTO();
        user = generateUser();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllTest() {
        when(userRepository.findAll()).thenReturn(List.of(user));
        when(responseMapper.mapToDTO(any(User.class))).thenReturn(responseDto);
        userService.getAll();
        verify(userRepository, times(1)).findAll();

    }




    @Test
    void getByIdTest() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        when(responseMapper.mapToDTO(any(User.class))).thenReturn(responseDto);

        userService.getById(1L);

        verify(userRepository, times(1)).findById(anyLong());
    }




    @Test
    public void notFoundExceptionTest() {
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, () -> userService.getById(any(Long.class)));

    }

}

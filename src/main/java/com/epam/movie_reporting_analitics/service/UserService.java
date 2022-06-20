package com.epam.movie_reporting_analitics.service;

import com.epam.movie_reporting_analitics.config.mapper.userMapper.UserResponseMapper;
import com.epam.movie_reporting_analitics.dto.UserResponseDTO;
import com.epam.movie_reporting_analitics.exeption.NotFoundException;
import com.epam.movie_reporting_analitics.model.User;
import com.epam.movie_reporting_analitics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements GenericService<UserResponseDTO> {
    private UserRepository userRepository;
    private UserResponseMapper userResponseMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserResponseMapper userResponseMapper) {
        this.userRepository = userRepository;
        this.userResponseMapper = userResponseMapper;
    }

    public List<UserResponseDTO> getAll() {
        List<User> allUser = userRepository.findAll();
        return allUser
                .stream()
                .map(user -> userResponseMapper.mapToDTO(user))
                .collect(Collectors.toList());
    }

    public UserResponseDTO getById(Long id) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            return userResponseMapper.mapToDTO(existingUser.get());
        } else {
            throw new NotFoundException("User not found");

        }
    }
}

package com.epam.movie_reporting_analitics.endpoint;

import com.epam.movie_reporting_analitics.dto.UserResponseDTO;
import com.epam.movie_reporting_analitics.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("")
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable("id") long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

}

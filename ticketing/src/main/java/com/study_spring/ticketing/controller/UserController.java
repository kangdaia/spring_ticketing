package com.study_spring.ticketing.controller;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study_spring.ticketing.dto.UserCreateDTO;
import com.study_spring.ticketing.service.UserService;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserCreateDTO> save(@Valid @RequestBody UserCreateDTO userCreateDTO) {
        UserCreateDTO response = userService.createUser(userCreateDTO);
        return ResponseEntity.ok().body(response);
    }
}

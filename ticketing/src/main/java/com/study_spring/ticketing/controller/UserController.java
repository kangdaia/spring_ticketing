package com.study_spring.ticketing.controller;

import com.study_spring.ticketing.dto.UserCreateDTO;
import com.study_spring.ticketing.service.UserService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study_spring.ticketing.domain.User;
import com.study_spring.ticketing.dto.UserCreateDTO;
import com.study_spring.ticketing.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> create(@Valid @RequestBody UserCreateDTO userCreateDTO) {
        UserCreateDTO response = userService.createUser(userCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response.getUsername());
    }

    @GetMapping("/user/login")
    public String loginForm() {
        return "login";
    }
    @PostMapping("/user/login")
    public String login(@ModelAttribute UserCreateDTO userCreateDTO){
        UserCreateDTO loginResult = userService.login(userCreateDTO);
        if (loginResult != null){
            // 성공
            return "main";
        } else {
          // 실패
            return "login";
        }

    }
}

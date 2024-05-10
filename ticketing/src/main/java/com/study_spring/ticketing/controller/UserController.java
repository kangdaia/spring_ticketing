package com.study_spring.ticketing.controller;

import com.study_spring.ticketing.dto.UserCreateDTO;
import com.study_spring.ticketing.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String user() {
        return "user controller";
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

package com.study_spring.ticketing.controller;


import com.study_spring.ticketing.service.UserLogoutService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LogoutController {

    private final UserLogoutService userLogoutService;

    public LogoutController(UserLogoutService userLogoutService) {
        this.userLogoutService = userLogoutService;
    }


//    @PostMapping("/logout")
//    public ResponseEntity<String> logout(
//            @Valid @RequestBody LoginDTO loginDto,
//            @RequestHeader("Refresh") String refreshToken
//    ) {
//        System.out.println(refreshToken);
//        userLogoutService.logout(loginDto.getUsername(), refreshToken);
//        return new ResponseEntity<>("Logged out successfully", HttpStatus.NO_CONTENT);
//    }

}

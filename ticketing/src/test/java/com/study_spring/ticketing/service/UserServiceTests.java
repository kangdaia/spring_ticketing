package com.study_spring.ticketing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.*;

import com.study_spring.ticketing.domain.User;
import com.study_spring.ticketing.dto.UserCreateDTO;
import com.study_spring.ticketing.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {
    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        UserCreateDTO user = new UserCreateDTO("user", "psw", "email@com.com", "010-2345-0000");
        User userEntity = user.toEntity();
        when(passwordEncoder.encode(anyString())).thenReturn("hashedPassword");
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));
        
        User created = userService.createUser(user);
        assertNotNull(created);
        assertEquals(user.getUsername(), created.getUsername());
        assertEquals("hashedPassword", created.getPassword());
        verify(passwordEncoder).encode(eq("psw"));
    }

    @Test
    public void testValidateDuplicateUsername() {
        String username = "existinguser";
        UserCreateDTO existingUser = new UserCreateDTO(username, "psw", "email@com.com", "010-2345-0000");;
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(existingUser.toEntity()));

        assertThrows(IllegalStateException.class, () -> userService.createUser(existingUser),
            "Should throw an exception for duplicate usernames.");
    }

    @Test
    public void testValidateDuplicateEmail() {
        String email = "somesame@test.com";
        UserCreateDTO existingUser = new UserCreateDTO("user1", "psw", email, "010-2345-0000");;
        when(userRepository.findByEmail(email)).thenReturn(Optional.of(existingUser.toEntity()));

        assertThrows(IllegalStateException.class, () -> userService.createUser(existingUser),
            "Should throw an exception for duplicate email.");
    }
}

package com.study_spring.ticketing.repository;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.study_spring.ticketing.domain.User;
import com.study_spring.ticketing.repository.UserRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    private User testUser;

    @BeforeEach
    public void beforeEach() {
        testUser = new User("testuser", "password1", "test@example.com", "010-0000-0000");
        entityManager.persist(testUser);
        entityManager.flush();
    }

    @Test
    public void testFindByEmail() {
        // when
        Optional<User> foundUser = userRepository.findByEmail("test@example.com");

        // then
        assertTrue(foundUser.isPresent());
        assertEquals(foundUser.get().getEmail(), testUser.getEmail());
    }

    @Test
    public void testFindByUsername() {
        // when
        Optional<User> foundUser = userRepository.findByUsername("testuser");

        // then
        assertTrue(foundUser.isPresent());
        assertEquals(foundUser.get().getUsername(), testUser.getUsername());
    }
}
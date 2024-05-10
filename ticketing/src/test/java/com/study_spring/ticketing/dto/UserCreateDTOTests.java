package com.study_spring.ticketing.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.*;

/**
 * This class tests {@link UserCreateDTO} class
 */
public class UserCreateDTOTests {
    private static Validator validator;

    @BeforeAll
    static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testUserCreateDTO_ValidationSuccess() {
        UserCreateDTO user = new UserCreateDTO("john_doe", "securePassword123", "john@example.com", "010-1111-0000");
        Set<ConstraintViolation<UserCreateDTO>> violations = validator.validate(user);
        assertTrue(violations.isEmpty(), "There should be no validation errors");
    }
    
    @Test
    void testUserCreateDTO_ValidationFailure_BlankUsername() {
        UserCreateDTO user = new UserCreateDTO("", "securePassword123", "notanemail", "010-1111-0000");
        Set<ConstraintViolation<UserCreateDTO>> violations = validator.validate(user);
        assertEquals(3, violations.size(), "There should be three validation errors");

        for (ConstraintViolation<UserCreateDTO> violation : violations) {
            System.out.println(violation.getMessage());  // Output error messages for debugging
        }
    }

    @Test
    void testUserCreateDTO_ValidationFailure_WrongPatternPassword() {
        UserCreateDTO user = new UserCreateDTO("username", "nonsecp", "some@email.com", "010-1111-0000");
        Set<ConstraintViolation<UserCreateDTO>> violations = validator.validate(user);
        assertEquals(2, violations.size(), "There should be one validation errors");

        for (ConstraintViolation<UserCreateDTO> violation : violations) {
            System.out.println(violation.getMessage());  // Output error messages for debugging
        }
    }

    @Test
    void testUserCreateDTO_ValidationFailure_WrongPatternPhone() {
        UserCreateDTO user = new UserCreateDTO("username", "securePassword123", "some@email.com", "010-00-0000");
        Set<ConstraintViolation<UserCreateDTO>> violations = validator.validate(user);
        assertEquals(1, violations.size(), "There should be one validation errors");

        for (ConstraintViolation<UserCreateDTO> violation : violations) {
            System.out.println(violation.getMessage());  // Output error messages for debugging
        }
    }
}

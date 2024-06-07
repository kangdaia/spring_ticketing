package com.study_spring.ticketing.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class tests {@link LoginDTO} class
 */
public class LoginDTOTest {
    private static ValidatorFactory factory;
    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testLoginDTO_ValidationSuccess() {
        UserDTO.LoginDTO loginDTO = new UserDTO.LoginDTO("testuser","Testuser123");
        Set<ConstraintViolation<UserDTO.LoginDTO>> violations = validator.validate(loginDTO);
        assertTrue(violations.isEmpty(), "There should be no validation errors");
    }


    @Test
    void  testLoginDTO_ValidationFailure_BlankUsername() {
        UserDTO.LoginDTO loginDTO = new UserDTO.LoginDTO("","Testuser123");
        Set<ConstraintViolation<UserDTO.LoginDTO>> violations = validator.validate(loginDTO);
        assertEquals(1, violations.size(), "There should be three validation errors");

        for (ConstraintViolation<UserDTO.LoginDTO> violation : violations) {
            System.out.println(violation.getMessage());  // Output error messages for debugging
        }
    }

    @Test
    void  testLoginDTO_ValidationFailure_BlankPassword() {
        UserDTO.LoginDTO loginDTO = new UserDTO.LoginDTO("testuser","");
        Set<ConstraintViolation<UserDTO.LoginDTO>> violations = validator.validate(loginDTO);
        assertEquals(1, violations.size(), "There should be three validation errors");

        for (ConstraintViolation<UserDTO.LoginDTO> violation : violations) {
            System.out.println(violation.getMessage());  // Output error messages for debugging
        }
    }


}
package com.zikriakmal.apifb.validation;

import com.zikriakmal.apifb.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private UserRepository userRepository; // Inject your repository

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        // Assuming the repository has a method to find users by email
        return !userRepository.existsByEmail(email);
    }
}

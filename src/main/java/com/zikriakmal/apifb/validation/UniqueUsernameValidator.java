package com.zikriakmal.apifb.validation;

import com.zikriakmal.apifb.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsernameValInt, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UniqueUsernameValInt constraintAnnotation) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return username != null && !userRepository.existsByUsername(username);
    }
}
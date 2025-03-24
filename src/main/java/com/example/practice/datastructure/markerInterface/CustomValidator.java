package com.example.practice.datastructure.markerInterface;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomValidator implements ConstraintValidator<CustomConstraint, String> {

    @Override
    public void initialize(CustomConstraint customConstraint) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value != null && value.matches("[A-Z]{2}[0-9]{4}");
    }
}

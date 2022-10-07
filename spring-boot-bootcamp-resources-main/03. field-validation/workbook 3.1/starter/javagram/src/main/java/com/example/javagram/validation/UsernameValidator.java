package com.example.javagram.validation;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<Username, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    Pattern pattern = Pattern.compile("[^a-z0-9]");
    Matcher matcher = pattern.matcher(value);
    if (!(matcher.find())) {
      return true;
    }
    return false;
  }
}

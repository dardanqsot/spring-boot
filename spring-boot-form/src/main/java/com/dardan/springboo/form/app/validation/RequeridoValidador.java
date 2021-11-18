package com.dardan.springboo.form.app.validation;


import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequeridoValidador implements ConstraintValidator<Requerido, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        //if( value == null || value.isEmpty() || value.isBlank()){
        if( value == null || !StringUtils.hasText(value)){
            return false;
        }
        return true;
    }
}

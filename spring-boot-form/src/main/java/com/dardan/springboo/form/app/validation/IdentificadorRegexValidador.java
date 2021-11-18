package com.dardan.springboo.form.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdentificadorRegexValidador implements ConstraintValidator<IdentificadorRegex, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value.matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")){
            return true;
        }
        return false;
    }
}

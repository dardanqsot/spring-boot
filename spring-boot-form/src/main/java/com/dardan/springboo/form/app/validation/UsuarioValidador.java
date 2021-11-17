package com.dardan.springboo.form.app.validation;

import com.dardan.springboo.form.app.models.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UsuarioValidador implements Validator {
    @Override
    public boolean supports(Class<?> clazz) { //soporte es para indicar que pojo va a validar
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario usuario = (Usuario) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre","requerido.usuario.nombre"); //el string debe ser el mismo nombre del atributo, y la llave del properties

        if(!usuario.getIdentificador().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")){
            errors.rejectValue("identificador", "pattern.usuario.identificador");
        }
    }
}

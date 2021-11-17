package com.dardan.springboo.form.app.controllers;

import com.dardan.springboo.form.app.models.domain.Usuario;
import com.dardan.springboo.form.app.validation.UsuarioValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.annotation.SessionScope;

import javax.validation.Valid;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private UsuarioValidador validador;

    @InitBinder
    public void initBinder(WebDataBinder binder){ //desacopla el validador
        binder.addValidators(validador); //EN LUGAR DE USAR set usamos add para adicionar a por defecto
    }

    @GetMapping("/form")
    public String form(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Darwin");
        usuario.setApellido("Quispe");
        usuario.setIdentificador("123.456.789-K");
        model.addAttribute("titulo", "Formulario usuarios");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status){ //Por defecto se usa el nombnre de la clase , pero con en model Atribute se puede cambiar de nombre

        //validador.validate(usuario, result);
        model.addAttribute("titulo", "Resultado form");
        if(result.hasErrors()){
/*            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err -> {
                errores.put(err.getField(), "El campo ".concat(err.getField().concat(" ").concat(err.getDefaultMessage())));
            });
            model.addAttribute("error", errores);*/
            status.setComplete();
            return "form";
        }

        model.addAttribute("usuario", usuario);
        return "resultado";
    }
}

package com.dardan.springboo.form.app.controllers;

import com.dardan.springboo.form.app.editors.NombreMayusculaEditor;
import com.dardan.springboo.form.app.editors.PaisPropertyEditor;
import com.dardan.springboo.form.app.models.domain.Pais;
import com.dardan.springboo.form.app.models.domain.Usuario;
import com.dardan.springboo.form.app.services.PaisService;
import com.dardan.springboo.form.app.validation.UsuarioValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.annotation.SessionScope;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private UsuarioValidador validador;

    @Autowired
    private PaisService paisService;

    @Autowired
    private PaisPropertyEditor paisPropertyEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder){ //desacopla el validador
        binder.addValidators(validador); //EN LUGAR DE USAR set usamos add para adicionar a por defecto
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); //la indulgencia si se va a realizar un parse y si sera estricto o tolerante
        binder.registerCustomEditor(Date.class, "fechaNacimiento",new CustomDateEditor(dateFormat, true)); //entre comillas x si se desea especificar un campo, sino quitarlo

        binder.registerCustomEditor(String.class, "nombre",new NombreMayusculaEditor());
        binder.registerCustomEditor(String.class, "apellido",new NombreMayusculaEditor());

        binder.registerCustomEditor(PaisPropertyEditor.class, "pais", paisPropertyEditor);

    }

    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises(){
        return paisService.listar();
    }

    @ModelAttribute("paises")
    public List<String> paises(){
        return Arrays.asList("España","Mexico","Perú","Colombia","Venezuela");
    }

    @ModelAttribute("paisesMap")
    public Map<String,String> paisesMap(){
        Map<String,String> paises = new HashMap<String, String>();
        paises.put("ES", "España");
        paises.put("MX", "Mexico");
        paises.put("CL", "Chile");
        paises.put("PE", "Perú");
        paises.put("AR", "Aregentina");
        return paises;
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

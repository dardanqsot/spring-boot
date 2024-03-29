package com.dardan.springboo.form.app.controllers;

import com.dardan.springboo.form.app.editors.NombreMayusculaEditor;
import com.dardan.springboo.form.app.editors.PaisPropertyEditor;
import com.dardan.springboo.form.app.editors.RolesEditor;
import com.dardan.springboo.form.app.models.domain.Pais;
import com.dardan.springboo.form.app.models.domain.Role;
import com.dardan.springboo.form.app.models.domain.Usuario;
import com.dardan.springboo.form.app.services.PaisService;
import com.dardan.springboo.form.app.services.RoleService;
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
    private RoleService roleService;

    @Autowired
    private PaisPropertyEditor paisPropertyEditor;

    @Autowired
    private RolesEditor rolesEdito;

    @InitBinder
    public void initBinder(WebDataBinder binder){ //desacopla el validador
        binder.addValidators(validador); //EN LUGAR DE USAR set usamos add para adicionar a por defecto
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); //la indulgencia si se va a realizar un parse y si sera estricto o tolerante
        binder.registerCustomEditor(Date.class, "fechaNacimiento",new CustomDateEditor(dateFormat, true)); //entre comillas x si se desea especificar un campo, sino quitarlo

        binder.registerCustomEditor(String.class, "nombre",new NombreMayusculaEditor());
        binder.registerCustomEditor(String.class, "apellido",new NombreMayusculaEditor());

        binder.registerCustomEditor(Pais.class, "pais", paisPropertyEditor);
        binder.registerCustomEditor(Role.class, "roles", rolesEdito);

    }

    @ModelAttribute("genero")
    public List<String> genero(){
        return Arrays.asList("Hombre", "Mujer");
    }

    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises(){
        return paisService.listar();
    }

    @ModelAttribute("listaRoles")
    public List<Role> listaRoles(){
        return this.roleService.listar();
    }

    @ModelAttribute("listaRolesString")
    public List<String> listaRolesString(){
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_MODERADOR");
        return roles;
    }

    @ModelAttribute("listaRolesMap")
    public Map<String,String> listaRolesMap(){
        Map<String,String> paises = new HashMap<String, String>();
        paises.put("ROLE_ADMIN", "Administrador");
        paises.put("ROLE_USER", "Usuario");
        paises.put("ROLE_MODERADOR", "Moderador");
        return paises;
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
        usuario.setHabilitar(true);
        usuario.setValorSecreto("Algún valor secreto ***** ");
        usuario.setPais(new Pais(2,"MX","Mexico"));
        usuario.setRoles(Arrays.asList(new Role(2, "Usuario", "ROLE_USER")));
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
            model.addAttribute("titulo", "Resultado form");
            return "form";
        }

        return "redirect:/ver";
    }

    @GetMapping("/ver")
    public String ver(@SessionAttribute(name="usuario", required = false) Usuario usuario, Model model, SessionStatus status){
        if(usuario == null){
            return "redirect:/form";
        }
        model.addAttribute("titulo", "Resultado form");
        status.setComplete(); //eimina la sesion
        return "resultado";
    }
}

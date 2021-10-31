package com.dardan.springboo.form.app.controllers;

import com.dardan.springboo.form.app.models.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("titulo", "Formulario usuarios");
        return "form";
    }

    @PostMapping("/form")
    public String procesar(Model model, @RequestParam(name="username") String username, //se puedo colocar el nombre en caso sean diferentes
                           @RequestParam String password,
                           @RequestParam String email){

        Usuario usuario = new Usuario(); //clase pojo no tiene sentido injectar ya que represanta los datos de la aplicacion a diferencia de un servicio o configuracion, utilidad etc
        // los datos por lo general no se inyectan se persisten, envian guardan enviar a vista etc, solo los reposito, service, etc
        usuario.setUsername(username);
        usuario.setEmail(email);
        usuario.setPassword(password);
        model.addAttribute("titulo", "Resultado form");
        model.addAttribute("usuario", usuario);
        return "resultado";
    }
}

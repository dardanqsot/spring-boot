package com.dardan.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        //return "redirect:/app/index";  //redirige a otra pagina ya sea del proyecto o externo
        return "forward:/app/index";  //seria la mejor opcion para no cambiar la ruta, sino ocultarla
    }
}

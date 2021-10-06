package com.dardan.springbootdi.app.controller;

import com.dardan.springbootdi.app.models.service.MiServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired   //sirve para inyectar un objeto guardado en el contenedor de spring
    private MiServicio servicio;

    @GetMapping({"/","","/index"})
    public String index(Model model) {
        model.addAttribute("objeto", servicio.operacion());
        return "index";
    }
}

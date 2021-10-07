package com.dardan.springbootdi.app.controller;

import com.dardan.springbootdi.app.models.service.IServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired   // @Autowired sirve para inyectar un objeto guardado en el contenedor de spring
    @Qualifier("miServicioSimple") // Para indicar un componente específico a utilizar, se puede usar sin el Primary
    private IServicio servicio;

    @GetMapping({"/","","/index"})
    public String index(Model model) {
        model.addAttribute("objeto", servicio.operacion());
        return "index";
    }
}

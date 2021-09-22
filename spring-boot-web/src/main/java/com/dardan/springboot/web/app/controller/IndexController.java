package com.dardan.springboot.web.app.controller;

import com.dardan.springboot.web.app.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/app") //ruta de primer nivel
public class IndexController {
        //COMENTARIO DE prueba para subir git cambio de ruta de proyecto local
    //@RequestMapping(value="/index",method= RequestMethod.GET)
    //@GetMapping(value="/index")
    //@GetMapping("/index")
    @GetMapping({"/index", "/", "", "/home"})
    public String index(Model model) {
        model.addAttribute("titulo","Hola Spring Framework con Model");
        return "index"; // tiene q existir una vista con ese nombre
    }
//  2 da forma
//    @GetMapping({"/index", "/", "/home"})
//    public String index(Map<String, Object> map) {
//        map.put("titulo", "Hola Spring Framework con Map");
//        return "index"; // tiene q existir una vista con ese nombre
//    }
// 3ra forma
//    @GetMapping({"/index", "/", "/home"})
//    public ModelAndView index(ModelAndView mv) {
//        mv.addObject("titulo", "Hola Spring Framework con ModelAndView");
//        mv.setViewName("index");
//        return mv; // tiene q existir una vista con ese nombre
//    }
    @RequestMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Darwin");
        usuario.setApellido("Quispe");
        usuario.setEmail("darwinqsot@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo","Perfil del Usuario: ".concat(usuario.getNombre()));
        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo","Listado de usuarios");
        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = Arrays.asList(new Usuario("Darwin", "Quispe", "darwinqsot@gmail.com"),
                new Usuario("Horge", "Perez", "darwinqsot@gmail.com"),
                new Usuario("Domingo Días", "zona del servidor", "darwinqsot@gmail.com"));
        return usuarios;
    }
}

package com.dardan.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/app") //ruta de primer nivel
public class IndexController {

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
}

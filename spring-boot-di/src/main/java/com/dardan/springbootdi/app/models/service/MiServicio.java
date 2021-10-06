package com.dardan.springbootdi.app.models.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MiServicio {

    public String operacion() {
        return "Ejecutando algun proceso importante con service ...";
    }
}

package com.dardan.springbootdi.app.models.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("miServicioSimple")
public class MiServicio implements IServicio {

    @Override
    public String operacion() {
        return "Ejecutando algun proceso importante simple2 con Interface service ...";
    }
}

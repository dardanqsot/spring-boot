package com.dardan.springbootdi.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("miServicioComplejo")
@Primary // permite seleccionar el componente por defecto a utilizar
public class MiServicioComplejo implements IServicio {

    @Override
    public String operacion() {
        return "Ejecutando algun proceso importante Complicado con Interface service ...";
    }
}

package com.dardan.springbootdi.app;

import com.dardan.springbootdi.app.models.service.IServicio;
import com.dardan.springbootdi.app.models.service.MiServicio;
import com.dardan.springbootdi.app.models.service.MiServicioComplejo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean("miServicioSimple")
    public IServicio registrarMiServicio(){
        return new MiServicio();
    }

    @Bean("miServicioComplejo")
    @Primary  //para ponerlo como defecto
    public IServicio registrarMiServicioComplejo(){
        return new MiServicioComplejo();
    }
}

package com.dardan.springbootdi.app;

import com.dardan.springbootdi.app.models.domain.ItemFactura;
import com.dardan.springbootdi.app.models.domain.Producto;
import com.dardan.springbootdi.app.models.service.IServicio;
import com.dardan.springbootdi.app.models.service.MiServicio;
import com.dardan.springbootdi.app.models.service.MiServicioComplejo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

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

    @Bean("itemFactura")
    public List<ItemFactura> registrarItems(){
        Producto producto1 = new Producto("Camara Sony",100);
        Producto producto2 = new Producto("Bicicleta aro 25",200);

        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2, 4);

        return Arrays.asList(linea1, linea2);
    }

    @Bean("itemFacturaOficina")
    @Primary
    public List<ItemFactura> registrarItemsOficina(){
        Producto producto1 = new Producto("Monitor LG",1000);
        Producto producto2 = new Producto("Teclado HP",2020);
        Producto producto3 = new Producto("NoteBook ASUS",1500);
        Producto producto4 = new Producto("Impresora HP",3500);

        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2, 4);
        ItemFactura linea3 = new ItemFactura(producto3, 1);
        ItemFactura linea4 = new ItemFactura(producto4, 5);

        return Arrays.asList(linea1, linea2, linea3, linea4);
    }
}


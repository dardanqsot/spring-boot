package com.dardan.springbootdi.app.models.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
public class Factura {

    @Value("${factura.descripcion}")
    private String descripcion;

    @Autowired
    private Cliente cliente;

    @Autowired
    private List<ItemFactura> items;

    @PostConstruct // Se ejecuta justo despues crear objeto y despues de la inyeccion de las dependencias
    public void inicializar() {
        cliente.setNombre(cliente.getNombre().concat(" ").concat(" Daniel"));
        descripcion = descripcion.concat(" del cliente:  ").concat(cliente.getNombre());

    }

    @PreDestroy
    public void destruir(){
        System.out.println("Factura Destruida: ".concat(descripcion));

    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }
}

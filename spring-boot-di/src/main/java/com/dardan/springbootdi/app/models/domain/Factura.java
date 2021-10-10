package com.dardan.springbootdi.app.models.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;
import java.util.List;

@Component
//@SessionScope
//@ApplicationScope
@RequestScope
public class Factura implements Serializable {
    private static final long serialVersionUID = 5227909119785649616L; //no tiene importancia ni impacto solo un ID de la serialización
    //en cualquier objeto clase o componente que se quiera guardar en una sesion, se debe implementar Serializable
    // la interfaz xq cuando se transporte o almacena un objeto de java , memoria, json, xml sesiones http, hibernate, etc
    // contexto de persistencia,el cual se reataurara en un objeto de java un clon de la clase


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

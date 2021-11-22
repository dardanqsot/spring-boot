package com.dardan.springboo.form.app.services;

import com.dardan.springboo.form.app.models.domain.Pais;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PaisServiceImpl implements PaisService{

    private List<Pais> lista;
    public PaisServiceImpl() {
        this.lista = Arrays.asList(
                new Pais(1,"ES","España"),
                new Pais(2,"MX","Mexico"),
                new Pais(3,"PE","Perú"),
                new Pais(4,"CO","Colombia"),
                new Pais(5,"VE","Venezuela"));
    }

    @Override
    public List<Pais> listar() {
        return lista;
    }

    @Override
    public Pais obtenerPorId(Integer id) {
        Pais resultado =null;
        for(Pais pais: lista){
            if(id == pais.getId()) {
                resultado = pais;
                break;
            }
        }
        return resultado;
    }
}

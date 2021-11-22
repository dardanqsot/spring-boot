package com.dardan.springboo.form.app.services;

import com.dardan.springboo.form.app.models.domain.Pais;

import java.util.List;

public interface PaisService {

    public List<Pais> listar();
    public Pais obtenerPorId(Integer id);
}

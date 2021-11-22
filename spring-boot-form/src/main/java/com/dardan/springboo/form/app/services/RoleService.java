package com.dardan.springboo.form.app.services;

import com.dardan.springboo.form.app.models.domain.Role;

import java.util.List;

public interface RoleService {

    public List<Role> listar();
    public Role obtenerPorId(Integer id);
}

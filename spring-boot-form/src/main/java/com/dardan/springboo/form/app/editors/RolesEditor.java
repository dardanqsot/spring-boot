package com.dardan.springboo.form.app.editors;

import com.dardan.springboo.form.app.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.beans.PropertyEditorSupport;

@Component
public class RolesEditor extends PropertyEditorSupport {
    @Autowired
    private RoleService roleService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try{
            Integer id = Integer.parseInt(text);
            setValue(roleService.obtenerPorId(id));
        }catch (NumberFormatException e){
            setValue(null);
        }
    }
}

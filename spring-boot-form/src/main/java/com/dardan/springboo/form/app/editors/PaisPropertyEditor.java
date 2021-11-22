package com.dardan.springboo.form.app.editors;

import com.dardan.springboo.form.app.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class PaisPropertyEditor extends PropertyEditorSupport {

    @Autowired
    private PaisService paisService;

    @Override
    public void setAsText(String idString) throws IllegalArgumentException {
        try {
            Integer id = Integer.parseInt(idString);
            this.setValue(paisService.obtenerPorId(id));
        } catch (Exception e) {
            setValue(null);
        }

    }
}

package com.fundamentos.springboot.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements  ComponentDependency{
    @Override
    public void saludar() {
        System.out.printf("Hola mundo desde mi componente");
    }
}

package com.fundamentos.springboot.bean;

public class MyBeanImplement implements MyBean{
    @Override
    public void print() {
        System.out.println("Hola desde mi implementación propia de bean");
    }
}

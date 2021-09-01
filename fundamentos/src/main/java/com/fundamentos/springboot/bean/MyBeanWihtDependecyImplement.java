package com.fundamentos.springboot.bean;

public class MyBeanWihtDependecyImplement implements MyBeanWihtDependecy{

    MyOperation myOperation;

    public MyBeanWihtDependecyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int numero = 1;
        System.out.println(myOperation.sum(numero));
        System.out.println("Hola desde la implementación de un bean con dependendia");
    }
}

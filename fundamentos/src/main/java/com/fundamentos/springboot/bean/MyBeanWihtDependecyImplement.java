package com.fundamentos.springboot.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWihtDependecyImplement implements MyBeanWihtDependecy{

    Log LOGGER = LogFactory.getLog(MyBeanWihtDependecyImplement.class);
    MyOperation myOperation;

    public MyBeanWihtDependecyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Hemos ingresado al metodo printWithDependency");;
        int numero = 1;
        LOGGER.debug("El número enviado como parámettro a la dependencia es: " + numero);
        System.out.println(myOperation.sum(numero));
        System.out.println("Hola desde la implementación de un bean con dependendia");
    }
}

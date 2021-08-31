package com.fundamentos.springboot;

import com.fundamentos.springboot.bean.MyBean;
import com.fundamentos.springboot.bean.MyBeanWihtDependecy;
import com.fundamentos.springboot.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWihtDependecy myBeanWihtDependecy;

    //Qualifier esta anotacion nos permite indicar que anotacion usar con esto  podemos usar N implementaciones a partir de una dependencia
    @Autowired //Esto ya no es obligatorio en versiones recientes de spring.
    public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWihtDependecy myBeanWihtDependecy){
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWihtDependecy = myBeanWihtDependecy;
    }
    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        componentDependency.saludar();
        myBean.print();
        myBeanWihtDependecy.printWithDependency();
    }
}

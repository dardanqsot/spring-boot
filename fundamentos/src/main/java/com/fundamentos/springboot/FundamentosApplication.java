package com.fundamentos.springboot;

import com.fundamentos.springboot.bean.MyBean;
import com.fundamentos.springboot.bean.MyBeanWihtDependecy;
import com.fundamentos.springboot.bean.MyBeanWithProperties;
import com.fundamentos.springboot.component.ComponentDependency;
import com.fundamentos.springboot.pojo.UserPojo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWihtDependecy myBeanWihtDependecy;
    private MyBeanWithProperties myBeanWithProperties;
    private UserPojo userPojo;

    //Qualifier esta anotacion nos permite indicar que anotacion usar con esto  podemos usar N implementaciones a partir de una dependencia
    @Autowired //Esto ya no es obligatorio en versiones recientes de spring.
    public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWihtDependecy myBeanWihtDependecy, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo){
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWihtDependecy = myBeanWihtDependecy;
        this.myBeanWithProperties = myBeanWithProperties;
        this.userPojo = userPojo;
    }
    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        componentDependency.saludar();
        myBean.print();
        myBeanWihtDependecy.printWithDependency();
        System.out.println(myBeanWithProperties.function());
        System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword());
        try{
            int valor = 10/0;
            LOGGER.debug("Mi valor: "+ valor);
        }catch (Exception e){
            LOGGER.error("Esto es un errro al dividir por cero " + e.getStackTrace());
        }
    }
}

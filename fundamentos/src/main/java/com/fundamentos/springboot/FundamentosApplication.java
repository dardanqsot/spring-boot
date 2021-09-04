package com.fundamentos.springboot;

import com.fundamentos.springboot.bean.MyBean;
import com.fundamentos.springboot.bean.MyBeanWihtDependecy;
import com.fundamentos.springboot.bean.MyBeanWithProperties;
import com.fundamentos.springboot.component.ComponentDependency;
import com.fundamentos.springboot.entity.User;
import com.fundamentos.springboot.pojo.UserPojo;
import com.fundamentos.springboot.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWihtDependecy myBeanWihtDependecy;
    private MyBeanWithProperties myBeanWithProperties;
    private UserPojo userPojo;
    private UserRepository userRepository;

    //Qualifier esta anotacion nos permite indicar que anotacion usar con esto  podemos usar N implementaciones a partir de una dependencia
    @Autowired //Esto ya no es obligatorio en versiones recientes de spring.
    public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWihtDependecy myBeanWihtDependecy, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository){
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWihtDependecy = myBeanWihtDependecy;
        this.myBeanWithProperties = myBeanWithProperties;
        this.userPojo = userPojo;
        this.userRepository = userRepository ;
    }
    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //ejemplosAnteriores();
        saveUsersInDataBase();

    }

    private void saveUsersInDataBase(){
        User user1 = new User("John","juan@gmail.com", LocalDate.of(2021,03,15));
        User user2 = new User("Luisa","Luia@gmail.com", LocalDate.of(2021,05,15));
        User user3 = new User("María","maría@gmail.com", LocalDate.of(2021,03,15));
        User user4 = new User("Otro","@mail.com", LocalDate.of(2021,05,15));
        List<User> list = Arrays.asList(user1,user2,user3,user4);
        list.stream().forEach(userRepository::save);
    }

    private void ejemplosAnteriores(){
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

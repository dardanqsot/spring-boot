package com.fundamentos.springboot.configuration;

import com.fundamentos.springboot.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperationanOperation(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWihtDependecy beanOperationOperationWithDependency(MyOperation myOperation){
        return new MyBeanWihtDependecyImplement(myOperation);
    }
}

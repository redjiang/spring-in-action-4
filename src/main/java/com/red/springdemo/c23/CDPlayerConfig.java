package com.red.springdemo.c23;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
@Import({CDConfig.class})
public class CDPlayerConfig {

    /**
     * 加了@Bean之后就会被spring管理起来，并不会每次都会调用sgtPeppers的，spring会拦截对该方法的调用，并
     * 确保直接返回SgtPeppers，而不是每次都直接调用
     * @return
     */
   /* @Bean
    //@Scope("prototype")
    public CompactDisc sgtPeppers() {
        System.out.println("运行了");
        return new SgtPeppers();
    }

    @Bean(name = "cd1")
    public CDPlayer cdPlayer() {
        return new CDPlayer(sgtPeppers());
    }

    @Bean(name = "cd2")
    public CDPlayer anotherCDPlayer() {
        return new CDPlayer(sgtPeppers());
    }*/



   @Bean
    public CDPlayer cdPlayer(CompactDisc cd){
       return new CDPlayer(cd);

   }
}

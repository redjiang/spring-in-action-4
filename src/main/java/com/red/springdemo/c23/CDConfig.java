package com.red.springdemo.c23;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author red
 * @date 2020-02-19
 */

@Configuration
public class CDConfig {

    @Bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }
}

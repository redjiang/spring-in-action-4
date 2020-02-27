package com.red.springdemo.dubb2;

import com.red.springdemo.dubb.CSFReference;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author red
 * @date 2020-02-21
 */
@Configuration
@ComponentScan
@CSFComponentScan
public class TestConfig {

//    @Bean
//    public AutowiredAnnotationBeanPostProcessor getAutowiredAnnotationBeanPostProcessor(){
//        AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
//        autowiredAnnotationBeanPostProcessor.setAutowiredAnnotationType(CSFReference.class);
//        return autowiredAnnotationBeanPostProcessor;
//    }
}

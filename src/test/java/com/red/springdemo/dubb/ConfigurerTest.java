package com.red.springdemo.dubb;

import com.red.springdemo.dubb2.Configurer;
import com.red.springdemo.dubb2.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author red
 * @date 2020-02-21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class ConfigurerTest {

    @Autowired
    private Configurer configurer;

    @Test
    public void testA(){
        configurer.helloB();
    }
}
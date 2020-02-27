package com.red.springdemo.c32;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author red
 * @date 2020-02-27
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class ConditionTest {

    @Autowired
    private MagicBean magicBean;

    @Test
    public void testCondition() {
        assertNotNull(magicBean);
    }
}
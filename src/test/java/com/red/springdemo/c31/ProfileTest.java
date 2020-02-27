package com.red.springdemo.c31;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author red
 * @date 2020-02-27
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration(classes = {TestConfig.class})
public class ProfileTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDataSource() {
        assertNull(dataSource);
    }
}

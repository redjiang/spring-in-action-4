package com.red.springdemo.c23;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author red
 * @date 2020-02-18
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CDPlayerConfig.class})
public class CDPlayerTest {

    /*@Autowired
    @Qualifier("cd1")
    private CDPlayer cdPlayer1;
    @Autowired
    @Qualifier("cd2")
    private CDPlayer cdPlayer2;

    @Test
    public void testCDPlayer() {
        System.out.println(cdPlayer1.cd);
        System.out.println(cdPlayer2.cd);
        assertNotNull(cdPlayer1);
    }*/

    @Autowired
    private CDPlayer cdPlayer;

    @Test
    public void testCDPlayer() {
        System.out.println(cdPlayer.cd);
        assertNotNull(cdPlayer);
    }
}
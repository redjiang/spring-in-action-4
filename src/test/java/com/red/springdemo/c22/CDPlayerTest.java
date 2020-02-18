package com.red.springdemo.c22;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath*:/*.xml")
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {
    /*@Autowired
    private CompactDisc compactDisc;

    @Test
    public void cdShouldBeNotNull() {
        assertNotNull(compactDisc);
    }*/
    @Rule
    public final SystemOutRule log = new SystemOutRule();
    @Autowired
    private MediaPlayer mediaPlayer;

    @Test
    public void testPlay(){
        log.enableLog();
        mediaPlayer.play();

        assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\r\n",
                log.getLog());
    }
}
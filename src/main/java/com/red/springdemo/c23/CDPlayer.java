package com.red.springdemo.c23;

import org.springframework.stereotype.Component;

public class CDPlayer implements MediaPlayer {


    /**
     * public仅仅为了测试
     */
    public CompactDisc cd;

    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }

    @Override
    public void play(){
        cd.play();
    }
}

package com.red.springdemo.c22;

import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {


    private CompactDisc cd;


    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }
    @Override
    public void play(){
        cd.play();
    }
}

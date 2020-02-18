package com.red.springdemo.c11;

import java.io.PrintStream;

public class SlayDragonRequest implements Quest {

    private PrintStream stream;

    public SlayDragonRequest(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void embark() {
        stream.println("embarking slay the Dragon!");
    }


}

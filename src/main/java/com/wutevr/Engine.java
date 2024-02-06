package com.wutevr;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
/**
 * responsible for holding the instance of the display,
 * Generating the frame rate, then updating objects every frame.
 */
public class Engine {
    public boolean shouldRun;
    public Engine(int refreshRate){
        shouldRun = true;
        Timer timer = new Timer();
    }

    public void run(){
        while(shouldRun){
            timer.
        }
    }
}

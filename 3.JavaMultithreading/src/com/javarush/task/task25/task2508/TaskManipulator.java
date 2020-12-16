package com.javarush.task.task25.task2508;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class TaskManipulator implements Runnable,CustomThreadManipulator {
    Thread thread;

    @Override
    public void run() {
        while(!thread.isInterrupted()) {
            System.out.println(thread.getName());
            try {
                sleep(100);
            } catch (InterruptedException e) {
                thread.interrupt();
            }
        }
    }

    @Override
    public void start(String threadName) {
        this.thread = new Thread(this,threadName);
        this.thread.start();
    }

    @Override
    public void stop() {
        this.thread.interrupt();
    }
}

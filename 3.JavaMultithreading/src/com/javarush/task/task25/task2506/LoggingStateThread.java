package com.javarush.task.task25.task2506;

public class LoggingStateThread extends  Thread{
    Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
        setDaemon(true);
    }

    @Override
    public void run() {
        String s = "";
        Thread.State currentState = null;
        while(true){
            if (target.getState() != currentState) {
                currentState = target.getState();
                System.out.println(currentState);
            }
            if (currentState == State.TERMINATED) {
                break;
            }
        }
    }
}

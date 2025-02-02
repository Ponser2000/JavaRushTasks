package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/

import static java.lang.Thread.*;
import static java.lang.Thread.State.NEW;

public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for(Thread thread : threads) {
            switch (thread.getState()) {
                case NEW :{
                    thread.start();
                    break;
                }
                case RUNNABLE :{
                    thread.isInterrupted();
                    break;
                }
                case TERMINATED : {
                    System.out.println(thread.getPriority());
                    break;
                }
                case BLOCKED :
                case TIMED_WAITING :
                case WAITING : {
                    thread.interrupt();
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + thread.getState());
            }
        }
    }

    public static void main(String[] args) {
    }
}

package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            try {
                //add your code here - добавьте код тут
                while(true){
                    if (numSeconds > 0 )  {
                        System.out.print(numSeconds + " ");
                        numSeconds--;
                        Thread.sleep(1000);
                    } else {
                        System.out.print("Марш! ");
                        break;
                    }
                }

            } catch (InterruptedException e) {
                System.out.println("Прервано!");
            }
        }
    }
}

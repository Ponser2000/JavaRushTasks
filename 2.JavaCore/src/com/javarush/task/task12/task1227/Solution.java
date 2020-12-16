package com.javarush.task.task12.task1227;

/* 
CanFly, CanRun, CanSwim для классов Duck, Penguin, Toad
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanRun {
        public void run();
    }

    public interface CanSwim {
        public void swim();
    }

    public class Duck implements  CanFly, CanRun, CanSwim{
        @java.lang.Override
        public void run() {

        }

        @java.lang.Override
        public void swim() {

        }

        @java.lang.Override
        public void fly() {

        }
    }

    public class Penguin implements  CanRun, CanSwim {
        @java.lang.Override
        public void run() {

        }

        @java.lang.Override
        public void swim() {

        }
    }

    public class Toad implements  CanSwim {
        @java.lang.Override
        public void swim() {

        }
    }
}

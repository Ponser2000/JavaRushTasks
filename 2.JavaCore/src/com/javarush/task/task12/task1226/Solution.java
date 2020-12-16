package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать
*/

public class Solution {

    public static void main(String[] args) {

    }

    public class Cat  implements CanClimb, CanRun{
        @java.lang.Override
        public void climb() {

        }

        @java.lang.Override
        public void run() {

        }
    }

    public class Dog implements CanRun {
        @java.lang.Override
        public void run() {

        }
    }

    public class Tiger extends Cat {
    }

    public class Duck implements CanFly, CanRun{
        @java.lang.Override
        public void fly() {

        }

        @java.lang.Override
        public void run() {

        }
    }

    public interface CanFly {
        void fly();
    }

    public interface CanRun {
        void run();
    }

    public interface CanClimb {
        void climb();
    }
}

package com.javarush.task.task13.task1301;

/* 
Пиво
*/
public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Drinker {
        void askForMore(String message);

        void sayThankYou();

        boolean isReadyToGoHome();
    }

    public interface Alcoholic extends Drinker {
        boolean READY_TO_GO_HOME = false;

        void sleepOnTheFloor();
    }

    public static class BeerLover implements Alcoholic {


        @java.lang.Override
        public void askForMore(String message) {

        }

        @java.lang.Override
        public boolean isReadyToGoHome() {
            return READY_TO_GO_HOME;
        }

        @java.lang.Override
        public void sleepOnTheFloor() {

        }

        @java.lang.Override
        public void sayThankYou() {

        }
    }
}
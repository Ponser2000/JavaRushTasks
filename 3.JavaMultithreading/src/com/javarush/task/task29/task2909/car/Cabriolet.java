package com.javarush.task.task29.task2909.car;

public class Cabriolet extends Car{
    public Cabriolet(int numberOfPassengers) {
        super(Car.CABRIOLET, numberOfPassengers);
    }

    public int getMaxSpeed(){
        final int MAX_CABRIOLET_SPEED = 90;
        return MAX_CABRIOLET_SPEED;
    }
}

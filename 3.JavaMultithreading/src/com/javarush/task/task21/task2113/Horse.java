package com.javarush.task.task21.task2113;

public class Horse {
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void move(){
        distance += Math.random()*speed;
    }

    public void print(){
        int rdot = (int) distance;

        for (int i=0; i< rdot; i++){
            System.out.print(".");
        }
        System.out.println(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return this.distance;
    }

    public double getSpeed() {
        return this.speed;
    }

}


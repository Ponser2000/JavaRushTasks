package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    static Hippodrome game;

    private List<Horse> horses;

    public List<Horse> getHorses(){
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = new ArrayList<>();
        this.horses = horses;
    }

    public void move(){
        for(Horse horse : horses) {
            horse.move();
        }
    }

    public void run() throws InterruptedException {
        for(int i=0; i<100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void print(){
        for(Horse horse : horses) {
            horse.print();
        }
        System.out.println("\n\n\n\n\n\n\n\n\n");
    }

    public Horse getWinner() {
        double maxDistance = 0.0;
        Horse winner = null;
        for(Horse horse : horses) {
            if(maxDistance<horse.distance) {
                maxDistance = horse.distance;
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        String winnerName = getWinner().name;
        System.out.println("Winner is "+winnerName+"!");
    }




    public static void main(String[] args) throws InterruptedException {

        List<Horse> horses  = new ArrayList<>();

        horses.add(new Horse("Name1",3.0, 0));
        horses.add(new Horse("Name2",3.0, 0));
        horses.add(new Horse("Name3",3.0, 0));

        game = new Hippodrome(horses);

        game.run();

        game.printWinner();
        
    }

}

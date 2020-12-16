package com.javarush.task.task06.task0603;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Cat> catArrayList = new ArrayList<>();
        ArrayList<Dog> dogArrayList = new ArrayList<>();

        for(int i=0; i<50000; i++){
            catArrayList.add(new Cat());
            dogArrayList.add(new Dog());
        }

    }
}

class Cat {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("A Cat was destroyed");
    }
}

class Dog {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("A Dog was destroyed");
    }
}

package com.javarush.task.task12.task1215;

/* 
Кошки не должны быть абстрактными!
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public abstract String getName();

        public abstract Pet getChild();
    }

    public static class Cat extends Pet {
        Pet pet;
        public String getName() {
            return "Я кошка";
        }

        public Pet getChild() {
            return pet;
        }


    }

    public static class Dog extends Pet{
        Pet pet;
        public String getName() {
            return "Я собака";
        }

        public Pet getChild() {
            return pet;
        }

    }

}

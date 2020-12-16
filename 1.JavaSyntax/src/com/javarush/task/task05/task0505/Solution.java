package com.javarush.task.task05.task0505;

/* 
Кошачья бойня
*/

public class Solution {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Katy",10,6,10);
        Cat cat2 = new Cat("Nyasha",6,4,6);
        Cat cat3 = new Cat("Luntik",5,5,7);

        if (cat1.fight(cat2))
            System.out.println("Win Cat1");
        else
            System.out.println("Win Cat2");

        if (cat1.fight(cat3))
            System.out.println("Win Cat1");
        else
            System.out.println("Win Cat3");
        if (cat3.fight(cat2))
            System.out.println("Win Cat3");
        else
            System.out.println("Win Cat2");

    }

    public static class Cat {

        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int ageScore = Integer.compare(this.age, anotherCat.age);
            int weightScore = Integer.compare(this.weight, anotherCat.weight);
            int strengthScore = Integer.compare(this.strength, anotherCat.strength);

            int score = ageScore + weightScore + strengthScore;
            return score > 0; // return score > 0 ? true : false;
        }
    }
}

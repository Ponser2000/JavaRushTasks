package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int cat1=0,cat2=0;
        if (this.age > anotherCat.age)
            cat1++;
        else if (this.age < anotherCat.age)
            cat2++;
        if (this.weight > anotherCat.weight)
            cat1++;
        else if (this.weight < anotherCat.weight)
            cat2++;
        if (this.strength>anotherCat.strength)
            cat1++;
        else if (this.strength<anotherCat.strength)
            cat2++;


            return cat1>cat2;


    }

    public static void main(String[] args) {

    }
}

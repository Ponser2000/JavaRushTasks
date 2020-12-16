package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<Human> famaly = new ArrayList<Human>();
        ArrayList<Human> child = new ArrayList<Human>();

        Human child1 = new Human("Valya",12,false);
        Human child2 = new Human("Petya",10,true);
        Human child3 = new Human("Kolya",6,true);

        child.add(child1);
        child.add(child2);
        child.add(child3);

        famaly.add(child1);
        famaly.add(child2);
        famaly.add(child3);

        Human mother = new Human("Olga",38,false,child);
        Human father = new Human("Sergey",45,false,child);

        ArrayList<Human> a_fath = new ArrayList<Human>();
        ArrayList<Human> a_moth = new ArrayList<Human>();
        a_fath.add(father);
        a_moth.add(mother);

        famaly.add(father);
        famaly.add(mother);

        Human grandmother1 = new Human("Olga",58,false,a_fath);
        Human grandfather1 = new Human("Sergey",65,false,a_fath);
        Human grandmother2 = new Human("Olga",68,false,a_moth);
        Human grandfather2 = new Human("Sergey",65,false,a_moth);

        famaly.add(grandfather1);
        famaly.add(grandmother1);
        famaly.add(grandfather2);
        famaly.add(grandmother2);

        for(Human h : famaly)
            System.out.println(h.toString());
    }

    public static class Human {
        String name;
        int age;
        boolean sex;
        ArrayList<Human> children;

        public Human(String name, int age, boolean sex){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children = new ArrayList<Human>();
        }

        public Human(String name, int age, boolean sex, ArrayList<Human> children){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}

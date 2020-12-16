package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human woman1 = new Human("Катя",false,55);
        Human woman2 = new Human("Оля",false,45);
        Human man1 = new Human("Петя",true,65);
        Human man2 = new Human("Костя",true,60);

        Human woman3 = new Human("Рита",false,25,man1,woman1);
        Human woman4 = new Human("Зоя",false,15,man1,woman1);
        Human woman5 = new Human("Ира",false,15,man2,woman1);

        Human man3 = new Human("Александр",true,6,man2,woman2);
        Human man4 = new Human("Алексей",true,16,man1,woman2);

        System.out.println(woman1);
        System.out.println(woman2);
        System.out.println(woman3);
        System.out.println(woman4);
        System.out.println(woman5);
        System.out.println(man1);
        System.out.println(man2);
        System.out.println(man3);
        System.out.println(man4);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}
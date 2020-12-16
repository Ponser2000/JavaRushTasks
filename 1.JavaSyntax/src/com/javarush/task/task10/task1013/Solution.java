package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String firstName;
        private String lastName;
        private Integer age;
        private boolean sex;
        private String address;
        private boolean hasAnimal;

        public Human(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Human(String firstName, String lastName,Integer age){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Human(String firstName, String lastName,Integer age,boolean sex){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
        }

        public Human(String firstName, String lastName,Integer age,boolean sex,String address){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.address = address;
        }

        public Human(String firstName, String lastName,Integer age,boolean sex,String address,boolean hasAnimal){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.address = address;
            this.hasAnimal = hasAnimal;
        }

        public Human(String firstName, Integer age,boolean sex,String address,boolean hasAnimal){
            this.firstName = firstName;
            this.age = age;
            this.sex = sex;
            this.address = address;
            this.hasAnimal = hasAnimal;
        }

        public Human(String firstName, String lastName,boolean sex,String address,boolean hasAnimal){
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.address = address;
            this.hasAnimal = hasAnimal;
        }

        public Human(String firstName, String lastName,String address,boolean hasAnimal){
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.hasAnimal = hasAnimal;
        }

        public Human(String firstName, String lastName,Integer age,boolean sex,boolean hasAnimal){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.hasAnimal = hasAnimal;
        }

        public Human(String firstName, String lastName,boolean hasAnimal){
            this.firstName = firstName;
            this.lastName = lastName;
            this.hasAnimal = hasAnimal;
        }

    }
}

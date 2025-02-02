package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandFatherName = reader.readLine();
        Cat catGrandFather = new Cat(grandFatherName);

        String grandMotherName = reader.readLine();
        Cat catGrandMother = new Cat(grandMotherName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName,catGrandFather,null);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName,null,catGrandMother);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catFather, catMother);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catFather, catMother);



        System.out.println(catGrandFather);
        System.out.println(catGrandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parent1;
        private Cat parent2;

        Cat(String name) {
            this.name = name;
        }


        Cat(String name, Cat parent1, Cat parent2) {
            this.name = name;
            if (parent1 != null)
                this.parent1 = parent1;
            if (parent2 != null)
                this.parent2 = parent2;
        }

        @Override
        public String toString() {
            String str_out="The cat's name is ";

            if (parent1 == null && parent2 == null)
                str_out = str_out + name + ", no mother , no father";
            else if (parent1 == null && parent2 != null)
                str_out = str_out + name + ", mother is " + parent2.name + ", no father";
            else if (parent1 != null && parent2 == null)
                str_out = str_out + name + ", no mother, father is " + parent1.name;
            else
                str_out = str_out + name + ", mother is " + parent2.name + ", father is " + parent1.name;


            return str_out;
        }
    }

}

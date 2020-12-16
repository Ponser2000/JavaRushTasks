package com.javarush.task.task04.task0433;

/* 
Гадание на долларовый счет
*/

public class Solution {
    public static void main(String[] args) {
        int i=0;
        String str1="";

        while (i < 10){
            str1=str1+"S";
            i++;
        }

        i=0;
        while (i<10) {
            System.out.println(str1);
            i++;
        }

    }
}

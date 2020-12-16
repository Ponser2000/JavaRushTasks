package com.javarush.task.task04.task0434;

/* 
Таблица умножения Ӏ Java Syntax: 4 уровень, 10 лекция
*/

public class Solution {
    public static void main(String[] args) {
        int i =1, j=1,p;
        String str1="";

        while (i < 11) {
            j=1;
            str1="";
            while (j < 10) {
                 p = i*j;
                str1=str1 + p +" ";
                j++;
            }
            p = i*j;
            str1 = str1 + p;
            System.out.println(str1);
            i++;
        }

    }
}

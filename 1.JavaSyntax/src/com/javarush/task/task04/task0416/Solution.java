package com.javarush.task.task04.task0416;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переходим дорогу вслепую
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        double n = Double.parseDouble(s);

        if ( (n % 5) >=0.0 && (n % 5) < 3.0) {
            System.out.println("зеленый");
        }
        if ( (n % 5) >=3.0 && (n % 5) < 4.0) {
            System.out.println("желтый");
        }
        if ( (n % 5) >=4.0 && (n % 5) < 5.0) {
            System.out.println("красный");
        }

    }
}
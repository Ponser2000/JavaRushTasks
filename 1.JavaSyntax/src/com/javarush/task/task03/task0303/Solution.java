package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(100,84.5));
        System.out.println(convertEurToUsd(75,84.5));

    }

    public static double convertEurToUsd(int eur, double exchangeRate) {
        return eur * exchangeRate;

    }
}

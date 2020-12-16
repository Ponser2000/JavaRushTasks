package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {

        int d3 = number / 100;
        int d2 = (number - d3 * 100) / 10;
        int d1 = number - d3 * 100 - d2 *10;

        return d1+d2+d3;

    }
}
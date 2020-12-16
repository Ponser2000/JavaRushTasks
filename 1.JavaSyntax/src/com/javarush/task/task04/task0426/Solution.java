package com.javarush.task.task04.task0426;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Ярлыки и числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        int n = Integer.parseInt(s);

        if (n > 0 && n % 2 == 0) {
            System.out.println("положительное четное число");
        } else if (n > 0 && n % 2 != 0) {
            System.out.println("положительное нечетное число");
        } else if (n < 0 && n % 2 == 0) {
            System.out.println("отрицательное  четное число");
        } else if (n < 0 && n % 2 != 0) {
            System.out.println("отрицательное  нечетное число");
        } else {
            System.out.println("ноль");
        }

    }
}

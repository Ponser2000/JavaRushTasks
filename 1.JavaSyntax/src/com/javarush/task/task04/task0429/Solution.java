package com.javarush.task.task04.task0429;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Положительные и отрицательные числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(bufferedReader.readLine());
        int n2 = Integer.parseInt(bufferedReader.readLine());
        int n3 = Integer.parseInt(bufferedReader.readLine());

        int min = 0;
        int plus = 0;

        if (n1 > 0) {
            plus++;
        } else if (n1 < 0) {
            min++;
        }
        if (n2 > 0) {
            plus++;
        } else if (n2 < 0) {
            min++;
        }
        if (n3 > 0) {
            plus++;
        } else if (n3 < 0) {
            min++;
        }

        System.out.println("количество отрицательных чисел: " + min);
        System.out.println("количество положительных чисел: " + plus);

    }
}

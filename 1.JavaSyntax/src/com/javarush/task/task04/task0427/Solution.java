package com.javarush.task.task04.task0427;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Описываем числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        if ( n % 2 == 0) {
            if ( n < 10 && n > 0) {
                System.out.println("четное однозначное число");
            } else if (n < 100 && n > 0) {
                System.out.println("четное двузначное число");
            }else if (n < 1000 && n > 0) {
                System.out.println("четное трехзначное число");
            }
        } else {
            if ( n < 10 && n > 0) {
                System.out.println("нечетное однозначное число");
            } else if (n < 100 && n > 0) {
                System.out.println("нечетное двузначное число");
            }else if (n < 1000 && n > 0) {
                System.out.println("нечетное трехзначное число");
            }
        }

    }
}

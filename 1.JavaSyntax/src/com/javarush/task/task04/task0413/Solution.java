package com.javarush.task.task04.task0413;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
День недели
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        int n = Integer.parseInt(s);

        if ( n > 0 && n < 8) {
            if (n == 1) System.out.printf("понедельник");
            if (n == 2) System.out.printf("вторник");
            if (n == 3) System.out.printf("среда");
            if (n == 4) System.out.printf("четверг");
            if (n == 5) System.out.printf("пятница");
            if (n == 6) System.out.printf("суббота");
            if (n == 7) System.out.printf("воскресенье");
        } else {
            System.out.println("такого дня недели не существует");
        }

    }
}
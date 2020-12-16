package com.javarush.task.task04.task0414;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Количество дней в году
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        int n = Integer.parseInt(s);

        if ( (n % 400) == 0 ) {
            System.out.println("количество дней в году: 366");
        } else if ( (n % 100) == 0 ) {
            System.out.println("количество дней в году: 365");
        } else if ( (n % 4) == 0 ) {
            System.out.println("количество дней в году: 366");
        } else {
            System.out.println("количество дней в году: 365");
        }

    }
}
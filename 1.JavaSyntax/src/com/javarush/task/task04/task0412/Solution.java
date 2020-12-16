package com.javarush.task.task04.task0412;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Положительное и отрицательное число
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        int n = Integer.parseInt(s);

        if ( n > 0 ) {
            System.out.println(n*2);
        } else if (n < 0) {
            System.out.println(n+1);
        } else {
            System.out.println(0);
        }

    }

}
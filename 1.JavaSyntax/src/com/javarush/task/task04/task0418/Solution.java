package com.javarush.task.task04.task0418;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Минимум двух чисел Ӏ Java Syntax: 4 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        int n1 = Integer.parseInt(s);

        s = bufferedReader.readLine();
        int n2 = Integer.parseInt(s);

        if ( n1 <= n2 )
            System.out.println(n1);
        else
            System.out.println(n2);

    }
}
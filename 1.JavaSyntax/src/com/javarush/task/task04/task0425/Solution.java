package com.javarush.task.task04.task0425;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Цель установлена!
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        int a = Integer.parseInt(s);

        s = bufferedReader.readLine();
        int b = Integer.parseInt(s);

        if ( a>0 && b>0)
            System.out.println(1);
        else
        if ( a<0 && b>0)
            System.out.println(2);
        else
        if ( a<0 && b<0)
            System.out.println(3);
        else
        if ( a>0 && b<0)
            System.out.println(4);
    }
}

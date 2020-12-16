package com.javarush.task.task04.task0417;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Существует ли пара?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        int a = Integer.parseInt(s);

        s = bufferedReader.readLine();
        int b = Integer.parseInt(s);

        s = bufferedReader.readLine();
        int c = Integer.parseInt(s);

        if ( a == b &&  a == c) {
            System.out.println(a + " " + b + " " + c);
        } else if ( a == b &&  a != c) {
            System.out.println(a + " " + b);
        }


        if ( a == c && a!=b) {
            System.out.println(a + " " + c);
        }


        if ( c == b && a!=b) {
            System.out.println(b + " " + c);
        }

    }
}
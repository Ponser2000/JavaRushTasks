package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a=0;
        int b=0;

        String str = reader.readLine();
        try {
            a = Integer.parseInt(str);
            if (a<=0) {
                throw new Exception();
            }
        }
        catch (Exception e) {
            throw e;
        }

        str = reader.readLine();
        try {
            b = Integer.parseInt(str);
            if (b<=0) {
                throw new Exception();
            }
        }
        catch (Exception e) {
            throw e;
        }
 //       System.out.println(a);
//        System.out.println(b);
        System.out.println(gcd_2(a,b));


    }


    public static int gcd_2(int a, int b) {
        int t;
        while (b != 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

}

package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {


        int maximum;
        int minimum;

        int[] a = new int[20];
        a=getInts();

        maximum = a[0];
        minimum = a[0];

        for(int i=1; i<a.length; i++){
            if (minimum > a[i])
                 minimum = a[i];
            if (maximum < a[i])
                maximum = a[i];
        }

        System.out.print(maximum + " " + minimum);
    }

    public static int[] getInts() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] res = new int[20];
        for(int i=0; i<20; i++)
            res[i]=Integer.parseInt(reader.readLine());

        return res;
    }

    //напишите тут ваш код
}

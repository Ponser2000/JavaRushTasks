package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] n0 = new int[15];

        int even=0;
        int odd=0;

        for(int i=0;i<n0.length;i++) {
            n0[i] = Integer.parseInt(reader.readLine());

            if ((i+2)%2==0)
                even +=n0[i];
            else
                odd +=n0[i];
        }

        if (even>odd)
            System.out.println("В домах с четными номерами проживает больше жителей.");
        else
            System.out.println("В домах с нечетными номерами проживает больше жителей.");

    }
}

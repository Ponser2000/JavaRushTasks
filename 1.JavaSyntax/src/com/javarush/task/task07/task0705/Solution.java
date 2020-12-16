package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] n0 = new int[20];
        int[] n1 = new int[10];
        int[] n2 = new int[10];

        for(int i=0;i<n0.length;i++)
            n0[i] = Integer.parseInt(reader.readLine());

        for(int i=0;i<n0.length/2;i++){
            n1[i] = n0[i];
            n2[i] = n0[i+10];
            System.out.println(n2[i]);
        }

    }
}

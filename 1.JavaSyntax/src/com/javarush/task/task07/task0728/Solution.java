package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        for(int i=array.length-1;i>=0;i--){
            for(int j=array.length-1; j>=i; j--) {
                if (array[i]<array[j]) {
                    int c = array[i];
                    array[i] = array[j];
                    array[j] = c;
                }
            }
        }
    }
}

package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Integer[] sorted_array = array;
        Arrays.sort(sorted_array);

        double mediana;


        if (sorted_array.length % 2 == 1) {
            mediana = sorted_array[sorted_array.length / 2];
        } else {
            mediana =0.5 *( sorted_array[sorted_array.length / 2 - 1] +  sorted_array[sorted_array.length / 2]);
        }

        double finalMediana = mediana;

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double a = Math.abs(finalMediana - o1);  //2
                double b = Math.abs(finalMediana - o2);  //3
                if (a > b) {
                    return 1;
                } else if (a < b) {
                    return -1;
                } else {
                    return o1<=o2 ? -1 : 1;
                }
            }
        };

        Arrays.sort(array,comparator);

        return array;
    }
}

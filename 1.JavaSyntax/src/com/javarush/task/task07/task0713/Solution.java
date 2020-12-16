package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list4 = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            list1.add(Integer.parseInt(reader.readLine()));
        }

        for(Integer x : list1){

            if (x % 3 == 0 && x % 2 == 0) {
                list2.add(x);
                list3.add(x);
            } else if (x % 3 == 0)
                list2.add(x);
            else if ( x % 2 == 0)
                list3.add(x);
            else
                list4.add(x);
        }


        printList(list2);
        printList(list3);
        printList(list4);
    }

    public static void printList(ArrayList<Integer> list) {
        for(Integer x : list)
            System.out.println(x);
    }
}

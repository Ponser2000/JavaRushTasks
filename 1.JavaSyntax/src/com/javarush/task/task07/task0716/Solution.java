package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        ArrayList<String> list = new ArrayList<String>();

        for(int i=0; i < strings.size() ; i++ ){

            boolean indexR = strings.get(i).contains("р");
            boolean indexL = strings.get(i).contains("л");

            if ( (indexL && indexR) || (!indexL && !indexR) )
                list.add(strings.get(i));
            else if (indexL && !indexR) {
                list.add(strings.get(i));
                list.add(strings.get(i));
            }
        }
        return list;
    }

}
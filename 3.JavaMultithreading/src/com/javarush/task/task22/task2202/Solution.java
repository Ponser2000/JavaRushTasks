package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {

        if (string == null) {
            throw new TooShortStringException();
        }


        String res="";
        String str = string;
        int count;
        ArrayList<Integer> space_index = new ArrayList<>();

        int index = 0;

        while(true) {
            int first = str.indexOf(" ",index);
            if (first < 0) {
                break;
            }
            space_index.add(first);
            index = first+1;
            // System.out.println(first);
        }

        if (space_index.size()<4) {
            throw new TooShortStringException();
        }

        if (space_index.size() == 4 ) {
            res = str.substring(space_index.get(0)+1);
        } else {
            res = str.substring(space_index.get(0)+1,space_index.get(4));
        }

        return res;
    }

    public static class TooShortStringException extends RuntimeException{
    }
}

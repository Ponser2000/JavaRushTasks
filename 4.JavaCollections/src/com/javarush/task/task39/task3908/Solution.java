package com.javarush.task.task39.task3908;

/* 
Возможен ли палиндром?
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();
        System.out.println(isPalindromePermutation(s));
    }

    public static boolean isPalindromePermutation(String s) {
        Map<Character,Integer> characterMap = new HashMap<>();
        char[] chars = s.toLowerCase().toCharArray();
        for (int i=0; i< chars.length; i++){
            if (characterMap.containsKey(chars[i])) {
                characterMap.put(chars[i],characterMap.get(chars[i])+1);
            } else {
                characterMap.put(chars[i],1);
            }
        }

        boolean flag = false;
        int count=0;
        for (Integer value : characterMap.values()){
            if (value % 2 != 0) {
                count++;
            }
        }
        flag = count < 2 ? true : false;

        return flag;
    }
}

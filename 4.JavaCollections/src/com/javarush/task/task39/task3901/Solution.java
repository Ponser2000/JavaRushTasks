package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        Set<Character> characterSet = new HashSet<>();
        int max = Integer.MIN_VALUE;
        if (s == null || s.length()==0) {
            return 0;
        }
        for(int i=0; i< s.length(); i++){
            characterSet.clear();
            for(int j=i; j<s.length(); j++){
                if(!characterSet.contains(s.charAt(j))) {
                    characterSet.add(s.charAt(j));
                } else  {
                    break;
                }
            }
            if (characterSet.size()>max) {
                max = characterSet.size();
            }
        }
        return max;
    }
}

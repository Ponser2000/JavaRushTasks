package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        ArrayList<Character> c1 = new ArrayList<>();
        ArrayList<Character> c2 = new ArrayList<>();
        for(char c : str.toCharArray()){
            if(isVowel(c))
                c1.add(c);
            else if (c != ' ')
                c2.add(c);
        }

        for(char c : c1)
            System.out.print(c + " ");

        System.out.println("");

        for(char c : c2)
            System.out.print(c + " ");
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}
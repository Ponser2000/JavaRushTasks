package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        Map<Character,Integer> counter = new HashMap<>();

        for(String str:list){
            String str1 = str.toLowerCase();
            for(int i = 0; i< str1.length(); i++){
                if(counter.containsKey(str1.charAt(i))) {
                    counter.put(str1.charAt(i), (counter.get(str1.charAt(i))+1) );
                } else {
                    counter.put(str1.charAt(i),1);
                }
            }
        }

        TreeMap<Character, Integer> sorted = new TreeMap<>();
        sorted.putAll(counter);

        for (Character c : alphabet) {
            int count = 0;
            if (sorted.get(c) != null ) {count = sorted.get(c);}
            System.out.println(c + " " + count);
        }
    }
}

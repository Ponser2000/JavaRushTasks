package com.javarush.task.task10.task1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String,Integer> map = new HashMap<>();

        while(true) {
            int id;
            try {
                id = Integer.parseInt(reader.readLine());
            }
            catch (NumberFormatException e) {break;}
            String name = reader.readLine();
            map.put(name,id);
        }

        for(Map.Entry<String,Integer> entry: map.entrySet()) {
            int id = entry.getValue();
            String name = entry.getKey();
            System.out.println(id + " " + name);
        }
    }
}

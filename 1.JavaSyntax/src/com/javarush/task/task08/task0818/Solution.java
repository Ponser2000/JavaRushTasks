package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String,Integer> map = new HashMap<>();
        map.put("Petrov",1000);
        map.put("Sidorov",700);
        map.put("Kozlov",200);
        map.put("Petr",100);
        map.put("Petrov1",300);
        map.put("Petrov2",600);
        map.put("Petrov3",900);
        map.put("Petrov4",1000);
        map.put("Petrov5",1100);
        map.put("Petrov6",100);

        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Map<String,Integer> copy = new HashMap<>(map);
        for(Map.Entry<String,Integer> pair : copy.entrySet()){
            if(pair.getValue() < 500)
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
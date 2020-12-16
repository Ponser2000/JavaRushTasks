package com.javarush.task.task18.task1821;


import javax.swing.plaf.basic.BasicButtonUI;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(args[0]);

        Map<Character, Integer> map = new HashMap<>();
        TreeMap<Character, Integer> treeMap = new TreeMap<Character, Integer>();

        while (inputStream.available()>0) {
            char b =(char) inputStream.read();
            if (map.containsKey(b)) {
                map.put(b,map.get(b)+1);
            } else {
                map.put(b,1);
            }
        }

        treeMap.putAll(map);

        for(Map.Entry<Character,Integer> entry : treeMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        inputStream.close();
    }
}

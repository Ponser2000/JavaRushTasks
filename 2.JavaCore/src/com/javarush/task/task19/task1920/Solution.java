package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import static java.lang.Double.compare;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = args[0];

        FileReader fileReader = new FileReader(filename);
        BufferedReader reader = new BufferedReader(fileReader);

        Map<String,Double> map = new HashMap<>();
        TreeMap<String, Double> sorted = new TreeMap<>();

        while(reader.ready()) {
            String[] s = reader.readLine().split(" ");
            map.put(s[0],(map.containsKey(s[0]) ? map.get(s[0]) + Double.parseDouble(s[1]) : Double.parseDouble(s[1])));
        }

        reader.close();
        fileReader.close();

        sorted.putAll(map);
        double max= sorted.firstEntry().getValue();

        for(double s : sorted.values()) {

            if (max < s) {
                max = s;
            }
        }


        for(Map.Entry<String,Double> s : sorted.entrySet()) {
            if (s.getValue().equals(max)) {
                System.out.println(s.getKey());
            }
        }

    }
}


package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        HashMap<Integer,Integer> fil = new HashMap<>();

        while (fileInputStream.available()>0) {
            int b = fileInputStream.read();
            if (fil.containsKey(b)) {
                fil.put(b,fil.get(b)+1);
            } else {
                fil.put(b,1);
            }
        }
        fileInputStream.close();

        Integer[] keys = fil.keySet().toArray(new Integer[0]);

        for(int i=0;i< keys.length; i++) {
            for(int j=i; j< keys.length; j++) {
                if (keys[i] > keys[j]) {
                    int m = keys[i];
                    keys[i] = keys[j];
                    keys[j] = m;
                }
            }
        }

        for (Integer key : keys) {
                System.out.print(key+" ");
        }
    }
}

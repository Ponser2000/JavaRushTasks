package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* 
Самые редкие байты
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

        int count = Integer.MAX_VALUE;

        for (Integer key : fil.keySet()) {
            if ( fil.get(key) < count) {
                count = fil.get(key);
            }
        }


        for (Integer key : fil.keySet()) {
            Integer val = fil.get(key);
            if (count == val) {
                System.out.print(key+" ");
            }
        }
    }
}

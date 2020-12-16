package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));

        String s,res;
        while((s = fileReader.readLine()) != null) {
            String[] str = s.split(" ");
            res="";
            for(int i=0; i< str.length; i++){
                for(int y : map.keySet()) {
                    if (str[i].equals(Integer.toString(y))) {
                        str[i] = map.get(y);
                    }
                }
                res = res + str[i] + " ";
            }
            res = res.trim();
            System.out.println(res);
        }
        reader.close();
        fileReader.close();
    }
}

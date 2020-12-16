package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.*;


/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        try {
            while(true) {
                int n = Integer.parseInt(reader.readLine());
                list.add(n);
            }
        }
        catch (NumberFormatException e) {
            for(Integer n : list)
                System.out.println(n);
        }
        catch (IOException e) {
            for(Integer n : list)
                System.out.println(n);
        }
    }
}

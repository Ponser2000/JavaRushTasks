package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str;

        try {
            str = reader.readLine();

            String[] str1 = str.split("[?]");

            String[] str2 = str1[1].split("&");


            for (String s : str2) {
                String[] s1 = s.split("=");
                System.out.print(s1[0] + " ");
            }
            System.out.println("");

            for (String s : str2) {
                String[] s1 = s.split("=");
                if (s1[0].equals("obj")) {

                    try {
                        alert(Double.parseDouble(s1[1]));
                    } catch (Exception e) {
                        alert(s1[1]);
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}

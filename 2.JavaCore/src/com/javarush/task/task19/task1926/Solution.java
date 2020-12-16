package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename = reader.readLine();

        reader.close();

        reader = new BufferedReader(new FileReader(filename));

        String str,res;

        while ((str = reader.readLine()) != null) {

            res="";
            for(int i=str.length()-1; i>=0; i--) {
                res=res+str.charAt(i);
            }
            System.out.println(res);
        }

        reader.close();


    }
}

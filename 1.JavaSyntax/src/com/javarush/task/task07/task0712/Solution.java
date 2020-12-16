package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> strings = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
        }


        int max=strings.get(0).length();
        int imax=0;

        int min=strings.get(0).length();
        int imin=0;


        for (int i = 0; i < strings.size(); i++) {
            if(max<strings.get(i).length())
                max=strings.get(i).length();
        }

        for (int i = 0; i < strings.size(); i++) {
            if(min>strings.get(i).length())
                min=strings.get(i).length();
        }

        for (int i = 0; i < strings.size(); i++) {
            if(min==strings.get(i).length()) {
                imin=i;
                break;
            }
        }

        for (int i = 0; i < strings.size(); i++) {
            if(max==strings.get(i).length()) {
                imax=i;
                break;
            }
        }

        if (imin<imax)
            System.out.println(strings.get(imin));
        else
            System.out.println(strings.get(imax));
    }
}

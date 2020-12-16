package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String,Integer> month = new HashMap<String,Integer>();
        month.put("JANUARY",1);
        month.put("FEBRUARY",2);
        month.put("MARCH",3);
        month.put("APRIL",4);
        month.put("MAY",5);
        month.put("JUNE",6);
        month.put("JULY",7);
        month.put("AUGUST",8);
        month.put("SEPTEMBER",9);
        month.put("OCTOBER",10);
        month.put("NOVEMBER",11);
        month.put("DECEMBER",12);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String m = reader.readLine();
        String m_u = m.toUpperCase();

        System.out.println(m + " is the " + month.get(m_u)+" month");
    }
}

package com.javarush.task.task22.task2208;

import java.util.Formatter;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder res = new StringBuilder();
        String ap;
        int count =0;

        for(Map.Entry<String,String> e : params.entrySet()) {

            String var = e.getKey();
            String value = e.getValue();

            if (value != null) {
                if (count == 0) {
                    ap = String.format("%s = '%s'",var,value);
                    count++;
                } else {
                    ap = String.format(" and %s = '%s'",var,value);
                }

                res.append(ap);
            }
        }

        return res.toString();
    }
}

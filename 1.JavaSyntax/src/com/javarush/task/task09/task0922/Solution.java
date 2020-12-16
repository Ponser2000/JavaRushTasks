package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");
        dateNow = formatForDateNow.parse(str);
        formatForDateNow = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        str = formatForDateNow.format(dateNow);
        System.out.println(str.toUpperCase());
    }
}

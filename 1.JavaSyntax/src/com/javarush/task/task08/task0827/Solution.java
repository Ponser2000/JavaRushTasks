package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        String[] s = date.split(" ");
        int year = Integer.parseInt(s[2]);

        Date yearStartTime = new Date();

        yearStartTime.setHours(0);
        yearStartTime.setMinutes(0);
        yearStartTime.setSeconds(0);

        yearStartTime.setDate(1);
        yearStartTime.setMonth(0);
        yearStartTime.setYear(year);

        Date currentTime = new Date();

        currentTime.setHours(0);
        currentTime.setMinutes(0);
        currentTime.setSeconds(0);

        currentTime.setDate(Integer.parseInt(s[1]));

        int month=0;

        switch(s[0]){
            case "JANURAY" :
                month=0;
                break;
            case "FEBRUARY" :
                month=1;
                break;
            case "March" :
                month=2;
                break;
            case "APRIL" :
                month=3;
                break;
            case "MAY" :
                month=4;
                break;
            case "JUNE" :
                month=5;
                break;
            case "JULY" :
                month=6;
                break;
            case "AUGUST" :
                month=7;
                break;
            case "SEPTEMBER" :
                month=8;
                break;
            case "OCTOBER" :
                month=9;
                break;
            case "NOVEMBER" :
                month=10;
                break;
            case "DECEMBER" :
                month=11;
                break;
        }
        currentTime.setMonth(month);
        currentTime.setYear(year);
        long msTimeDistance = currentTime.getTime() - yearStartTime.getTime();
        long msDay = 24 * 60 * 60 * 1000;
        int dayCount = ((int) (msTimeDistance/msDay)) + 1;
        boolean res = (dayCount % 2 == 0) ? false : true;
        return res;
    }
}

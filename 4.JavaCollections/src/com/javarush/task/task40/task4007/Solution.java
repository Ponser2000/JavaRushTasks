package com.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Работа с датами
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код

        Pattern p1 = Pattern.compile("^\\d{1,2}:\\d{1,2}:\\d{1,2}$");
        Pattern p2 = Pattern.compile("^\\d{1,2}.\\d{1,2}.\\d\\d\\d\\d$");
        Pattern p3 = Pattern.compile("^\\d{1,2}.\\d{1,2}.\\d\\d\\d\\d \\d{1,2}:\\d{1,2}:\\d{1,2}$");

        Matcher m1 = p1.matcher(date);
        Matcher m2 = p2.matcher(date);
        Matcher m3 = p3.matcher(date);
        try {
            if (m1.matches()) {
                Calendar instance = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss",
                    Locale.ENGLISH);
                instance.setTime(simpleDateFormat.parse(date));
                printTimeCalendar(instance);
            } else if (m2.matches()) {
                Calendar instance = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy",
                    Locale.ENGLISH);
                instance.setTime(simpleDateFormat.parse(date));
                printDateCalendar(instance);
            } else if (m3.matches()) {
                Calendar instance = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss",
                    Locale.ENGLISH);
                instance.setTime(simpleDateFormat.parse(date));
                printDateCalendar(instance);
                printTimeCalendar(instance);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static void printDateCalendar(Calendar instance) {
        System.out.println("День: " + instance.get(Calendar.DATE));
        int i = instance.get(Calendar.DAY_OF_WEEK);
        System.out.println("День недели: " + (i == 1 ? 7: (i - 1)));
        System.out.println("День месяца: " + instance.get(Calendar.DAY_OF_MONTH));
        System.out.println("День года: " + instance.get(Calendar.DAY_OF_YEAR));
        System.out.println("Неделя месяца: " + instance.get(Calendar.WEEK_OF_MONTH));
        System.out.println("Неделя года: " + instance.get(Calendar.WEEK_OF_YEAR));
        System.out.println("Месяц: " + (instance.get(Calendar.MONTH) + 1));
        System.out.println("Год: " + instance.get(Calendar.YEAR));
    }

    private static void printTimeCalendar(Calendar instance) {
        int i = instance.get(Calendar.AM_PM);
        System.out.println("AM или PM: " + (i == 0 ? "AM" : "PM"));
        System.out.println("Часы: " + instance.get(Calendar.HOUR));
        System.out.println("Часы дня: " + instance.get(Calendar.HOUR_OF_DAY));
        System.out.println("Минуты: " + instance.get(Calendar.MINUTE));
        System.out.println("Секунды: " + instance.get(Calendar.SECOND));
    }

}

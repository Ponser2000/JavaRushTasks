package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Iterator;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне"+"."+Math.random(), dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне"+"."+Math.random(), dateFormat.parse("MARCH 1 2012"));
        map.put("Сталлоне"+"."+Math.random(), dateFormat.parse("JUNE 10 2010"));
        map.put("Сталлоне"+"."+Math.random(), dateFormat.parse("SEPTEMBER 1 2012"));
        map.put("Сталлоне"+"."+Math.random(), dateFormat.parse("AUGUST 1 2012"));
        map.put("Сталлоне"+"."+Math.random(), dateFormat.parse("JULY 1 2012"));
        map.put("Сталлоне"+"."+Math.random(), dateFormat.parse("OCTOBER 1 2012"));
        map.put("Сталлоне"+"."+Math.random(), dateFormat.parse("NOVEMBER 1 2012"));
        map.put("Сталлоне"+"."+Math.random(), dateFormat.parse("AUGUST 31 2012"));
        map.put("Сталлоне"+"."+Math.random(), dateFormat.parse("SEPTEMBER 1 2012"));

        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {

        Iterator<Map.Entry<String,Date>> iterator = map.entrySet().iterator();


        while (iterator.hasNext()){
            Map.Entry<String, Date> pair = iterator.next();
            String key = pair.getKey();
            String value = pair.getValue().toString();

            if (value.contains("Jun"))
                iterator.remove();
            else if (value.contains("Jul"))
                iterator.remove();
            else if (value.contains("Aug"))
                iterator.remove();
        }

    }

    public static void main(String[] args) {

    }
}

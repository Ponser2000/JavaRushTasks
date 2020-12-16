package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        Map<String, String> map = new HashMap<String,String>();
        map.put(new String("Сидоров"),"Андрей");
        map.put(new String("Иванов"),"Сергей");
        map.put(new String("Петров"),"Алексей");
        map.put(new String("Петров"),"Иван");
        map.put(new String("Казорин"),"Олег");
        map.put(new String("Сидоров"),"Олег");
        map.put(new String("Пономарев"),"Сергей");
        map.put(new String("Коротков"),"Эдуард");
        map.put(new String("Кириллов"),"Кирилл");
        map.put(new String("Иванов"),"Петр");
        return map;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}

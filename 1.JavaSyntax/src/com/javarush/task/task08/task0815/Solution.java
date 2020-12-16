package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String,String> map = new HashMap<String,String>();
        map.put("Сидоров - Андрей","Андрей");
        map.put("Иванов - Сергей","Сергей");
        map.put("Петров - Алексей","Алексей");
        map.put("Козлов - Иван","Иван");
        map.put("Казорин - Олег","Олег");
        map.put("Мельников - Олег","Олег");
        map.put("Пономарев - Сергей","Сергей");
        map.put("Коротков - Эдуард","Эдуард");
        map.put("Кириллов - Кирилл","Кирилл");
        map.put("Иванов - Петр","Петр");

        return map;

    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int count=0;
        for(Map.Entry<String, String> pair : map.entrySet()){
            String s = pair.getValue();
            if (s.equals(name))
                count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int count=0;
        for(Map.Entry<String, String> pair : map.entrySet()){
            String[] s = pair.getKey().split(" - ");
            if (s[0].equals(lastName))
                count++;
        }
        return count;

    }

    public static void main(String[] args) {

    }
}

package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
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

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String, String> copy = new HashMap<>(map);

        Map<String,Integer> db2 = new HashMap<>();

        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if(db2.containsKey(pair.getValue())){
                Integer val = db2.get(pair.getValue()) + 1;
                db2.put(pair.getValue(),val);
            } else
                db2.put(pair.getValue(),1);
        }

        for (Map.Entry<String,Integer> pair : db2.entrySet()){
            if(pair.getValue()>1)
                removeItemFromMapByValue(map,pair.getKey());
        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}

package com.javarush.task.task36.task3607;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.DelayQueue;

/* 
Найти класс по описанию Ӏ Java Collections: 6 уровень, 10 лекция
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {

        return DelayQueue.class;
    }
}

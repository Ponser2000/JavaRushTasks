package com.javarush.task.task26.task2603;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 
Убежденному убеждать других не трудно
*/

public class Solution {
    public static CustomizedComparator cc;

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... vararg) {
            comparators = vararg;
            for (int i = 0; i < vararg.length; i++) {
                comparators[i]=vararg[i];
            }
        }

        @Override
        public int compare(T o1, T o2) {
            for (int i = 0; i < comparators.length; i++) {
                Comparator<T> c=   comparators[i];

                int result=c.compare(o1, o2);
                if(result!=0){
                    return result;
                }
            }
            return 0;
        }
    }

    public static class SomeObj{
        String a;
        Integer b;

        public SomeObj(String a, Integer b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Comparator<SomeObj> c1 = new Comparator<SomeObj>() {
            @Override
            public int compare(SomeObj o1, SomeObj o2) {
                return o1.a.compareTo(o2.a);
            }
        };

        Comparator<SomeObj> c2 = new Comparator<SomeObj>() {
            @Override
            public int compare(SomeObj o1, SomeObj o2) {
                return o1.b.compareTo(o2.b);
            }
        };

        cc=new CustomizedComparator(c1, c2);

        ArrayList<SomeObj> list = new ArrayList<>();
        list.add(new SomeObj("123", 124));
        list.add(new SomeObj("123", 121));


        Collections.sort(list, cc);
        System.out.println("done");
    }
}


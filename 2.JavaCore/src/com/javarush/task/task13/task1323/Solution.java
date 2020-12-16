package com.javarush.task.task13.task1323;

/* 
Интерфейс Updatable в классе Screen
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface Selectable {
        void onSelect();
    }

    interface Updatable extends Selectable {
        void refresh();
    }

    class Screen implements Updatable{
        @java.lang.Override
        public void onSelect() {

        }

        @java.lang.Override
        public void refresh() {

        }
    }
}

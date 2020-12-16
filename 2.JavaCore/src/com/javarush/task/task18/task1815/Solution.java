package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface{

        private TableInterface construct;

        public TableInterfaceWrapper(TableInterface construct) {
            this.construct = construct;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            construct.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return construct.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            construct.setHeaderText(newHeaderText);

        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}
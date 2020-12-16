package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen implements Country{
    public int getCountOfEggsPerMonth(){
        return 30;
    }

    public String getDescription(){
        String str = super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
        return str;
    }
}

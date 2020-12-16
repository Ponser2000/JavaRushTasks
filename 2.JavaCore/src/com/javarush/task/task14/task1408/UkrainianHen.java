package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen implements Country{
    public int getCountOfEggsPerMonth(){
        return 20;
    }
    public String getDescription(){
        String str = super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
        return str;
    }
}

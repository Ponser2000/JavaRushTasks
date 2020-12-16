package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen implements Country{
    public int getCountOfEggsPerMonth(){
        return 15;
    }

    public String getDescription(){
        String str = super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
        return str;
    }
}

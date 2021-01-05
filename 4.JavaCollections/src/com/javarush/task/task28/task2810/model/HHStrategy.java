package com.javarush.task.task28.task2810.model;

/**
 * @author Sergey Ponomarev on 05.01.2021
 * @project JavaRushTasks/com.javarush.task.task28.task2810.model
 */

// https://grc.ua/search/vacancy?L_is_autosearch=false&area=5&clusters=true&enable_snippets=true&text=java+Kiev&page=1

public class HHStrategy implements Strategy{

  private static final String URL_FORMAT = "https://hh.ru/search/vacancy?text=java+%s&page=%d";

  private static final String LINK = String.format(URL_FORMAT, "Kiev", 3);
}

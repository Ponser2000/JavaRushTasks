package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import java.util.Locale;

/**
 * @author Sergey Ponomarev on 07.01.2021
 * @project JavaRushTasks/com.javarush.task.task26.task2613
 */
public class CashMachine {

  public static void main(String[] args) {
    Locale.setDefault(Locale.ENGLISH);
    Operation operation = null;
    do {
      operation = ConsoleHelper.askOperation();
      CommandExecutor.execute(operation);
    }
    while (operation != Operation.EXIT);
  }
}

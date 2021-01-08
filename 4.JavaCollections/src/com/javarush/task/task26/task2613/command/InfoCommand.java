package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

/**
 * @author Sergey Ponomarev on 08.01.2021
 * @project JavaRushTasks/com.javarush.task.task26.task2613.command
 */
class InfoCommand implements Command{

  @Override
  public void execute() {
    ConsoleHelper.writeMessage("Информация:");
    boolean hasMoney = false;
    for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
      if (manipulator.hasMoney()) {
        hasMoney = true;
        ConsoleHelper.writeMessage("\t" + manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
      }
    }

    if (!hasMoney) {
      ConsoleHelper.writeMessage("Нет доступных средств.");
    }
  }
}

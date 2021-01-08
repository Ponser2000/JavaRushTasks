package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

/**
 * @author Sergey Ponomarev on 08.01.2021
 * @project JavaRushTasks/com.javarush.task.task26.task2613.command
 */
class ExitCommand implements Command{

  @Override
  public void execute() throws InterruptOperationException {
    ConsoleHelper.writeMessage("Вы точно хотите завершить работу? <y,n>");
    String result = ConsoleHelper.readString();
    if (result != null && "y".equals(result.toLowerCase())) {
      ConsoleHelper.writeMessage("Спасибо, что воспользовались нашим терминалом. Удачи.");
    } else {
      //TODO process NO
    }
  }
}

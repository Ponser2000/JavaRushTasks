package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import java.util.ResourceBundle;

/**
 * @author Sergey Ponomarev on 08.01.2021
 * @project JavaRushTasks/com.javarush.task.task26.task2613.command
 */
class ExitCommand implements Command {

  private ResourceBundle res = ResourceBundle
      .getBundle(CashMachine.RESOURCE_PATH + "exit_en");

  @Override
  public void execute() throws InterruptOperationException {
    ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
    String result = ConsoleHelper.readString();
    if (result != null && "y".equals(result.toLowerCase())) {
      ConsoleHelper.writeMessage(res.getString("thank.message"));
    } else {
      //TODO process NO
    }
  }
}

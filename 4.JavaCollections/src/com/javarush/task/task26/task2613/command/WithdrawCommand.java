package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;
import java.util.Map;

/**
 * @author Sergey Ponomarev on 08.01.2021
 * @project JavaRushTasks/com.javarush.task.task26.task2613.command
 */
class WithdrawCommand implements Command{

  @Override
  public void execute() throws InterruptOperationException {
    ConsoleHelper.writeMessage("Withdrawing...");

    String currencyCode = ConsoleHelper.askCurrencyCode();
    CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

    while (true) {
      try {
        ConsoleHelper.writeMessage("Пожалуйста, введите сумму для снятия.");
        String s = ConsoleHelper.readString();
        if (s == null) {
          ConsoleHelper.writeMessage("Пожалуйста, введи правильную сумму.");
        } else {
          try {
            int amount = Integer.parseInt(s);
            boolean isAmountAvailable = manipulator.isAmountAvailable(amount);
            if (isAmountAvailable) {
              Map<Integer, Integer> denominations = manipulator.withdrawAmount(amount);
              for (Integer item : denominations.keySet()) {
                ConsoleHelper.writeMessage("\t" + item + " - " + denominations.get(item));
              }

              ConsoleHelper.writeMessage(String.format("%d %s снятие прошло успешно", amount, currencyCode));
              break;
            } else {
              ConsoleHelper.writeMessage("На вашем счете недостаточно средств, повторите ввод");
            }
          } catch (NumberFormatException e) {
            ConsoleHelper.writeMessage("Пожалуйста, введи правильную сумму.");
          }
        }
      } catch (NotEnoughMoneyException e) {
        ConsoleHelper.writeMessage("На вашем счете недостаточно средств.");
      }
    }
  }
}

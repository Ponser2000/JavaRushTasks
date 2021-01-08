package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import java.util.ResourceBundle;

/**
 * @author Sergey Ponomarev on 08.01.2021
 * @project JavaRushTasks/com.javarush.task.task26.task2613.command
 */
public class LoginCommand implements Command {

  private ResourceBundle validCreditCards = ResourceBundle
      .getBundle(CashMachine.class.getPackage().getName() + ".resources.verifiedCards");

  @Override
  public void execute() throws InterruptOperationException {
    ConsoleHelper.writeMessage("Попытка входа...");

    while (true) {
      ConsoleHelper
          .writeMessage("Введите номер кредитной карты и пин-код или наберите 'EXIT' для выхода.");
      String creditCardNumber = ConsoleHelper.readString();
      String pinStr = ConsoleHelper.readString();
      if (creditCardNumber == null || (creditCardNumber = creditCardNumber.trim()).length() != 12 ||
          pinStr == null || (pinStr = pinStr.trim()).length() != 4) {
        ConsoleHelper
            .writeMessage("Введите правильный номер кредитной карты - 12 цифр, пин-код - 4 цифры.");
      } else {
        try {
          if (validCreditCards.containsKey(creditCardNumber) && pinStr
              .equals(validCreditCards.getString(creditCardNumber))) {
            ConsoleHelper.writeMessage(
                String.format("Кредитная карта [%s] прошла проверку!", creditCardNumber));
            break;
          } else {
            ConsoleHelper.writeMessage(
                String.format("Кредитная карта [%s] не прошла проверку.", creditCardNumber));
            ConsoleHelper.writeMessage(
                "Повторите ввод или наберите  'EXIT' для немедленного завершения операции");
          }
        } catch (NumberFormatException e) {
          ConsoleHelper.writeMessage(
              "Введите правильный номер кредитной карты - 12 цифр, пин-код - 4 цифры.");
        }
      }
    }

  }
}

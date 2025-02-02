package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.Operation;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Ponomarev on 08.01.2021
 * @project JavaRushTasks/com.javarush.task.task26.task2613.command
 */
public class CommandExecutor {
  private static final Map<Operation, Command> allKnownCommandsMap = new HashMap<>();

  static {
    allKnownCommandsMap.put(Operation.LOGIN, new LoginCommand());
    allKnownCommandsMap.put(Operation.INFO,new InfoCommand());
    allKnownCommandsMap.put(Operation.EXIT,new ExitCommand());
    allKnownCommandsMap.put(Operation.WITHDRAW,new WithdrawCommand());
    allKnownCommandsMap.put(Operation.DEPOSIT,new DepositCommand());
  }

  private CommandExecutor(){}
  
  public static final void execute(Operation operation) throws InterruptOperationException {
    CommandExecutor.allKnownCommandsMap.get(operation).execute();
  }

}

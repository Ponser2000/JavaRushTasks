package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

/**
 * @author Sergey Ponomarev on 08.01.2021
 * @project JavaRushTasks/com.javarush.task.task26.task2613.command
 */
interface Command {
   void execute()throws InterruptOperationException;
}

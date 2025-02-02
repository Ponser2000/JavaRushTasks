package com.javarush.task.task37.task3711;

/**
 * @author Sergey Ponomarev on 04.01.2021
 * @project JavaRushTasks/com.javarush.task.task37.task3711
 */
public class Computer {
  CPU cpu;
  Memory memory;
  HardDrive hardDrive;

  public Computer(){
    this.cpu = new CPU();
    this.memory = new Memory();
    this.hardDrive  = new HardDrive();
  }

  public void run(){
    cpu.calculate();
    memory.allocate();
    hardDrive.storeData();
  }
}

package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.ExceptionHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Sergey Ponomarev on 03.01.2021
 * @project JavaRushTasks/com.javarush.task.task33.task3310.strategy
 */
public class FileBucket {
  private Path path;

  public FileBucket() {
    try {
      path = Files.createTempFile("tmp", null);
      Files.deleteIfExists(path);
      Files.createFile(path);
    } catch (IOException e) {
      ExceptionHandler.log(e);
    }
    path.toFile().deleteOnExit();

  }

  public long getFileSize(){
    try {
      return Files.size(path);
    } catch (IOException e) {
      ExceptionHandler.log(e);
    }
    return 0L;
  }

  public void putEntry(Entry entry){
    try {
      OutputStream outputStream1 = Files.newOutputStream(path);
      ObjectOutputStream outputStream = new ObjectOutputStream(outputStream1);
      outputStream.writeObject(entry);
      outputStream1.close();
      outputStream.close();

    }
    catch (Exception e) {
      ExceptionHandler.log(e);
    }

  }

  public Entry getEntry(){
    Entry entry = null;
    if(getFileSize() > 0) {
      try {
        InputStream fis = Files.newInputStream(path);
        ObjectInputStream inputStream = new ObjectInputStream(fis);
        Object object = inputStream.readObject();
        fis.close();
        inputStream.close();
        entry = (Entry)object;
      }
      catch (Exception e) {
        ExceptionHandler.log(e);
      }
    }
    return entry;

  }

  public void remove(){
    try {
      Files.delete(path);
    } catch (IOException e) {
      ExceptionHandler.log(e);
    }
  }
  
}

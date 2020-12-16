package com.javarush.task.task32.task3209;


import java.io.File;
import javax.swing.filechooser.FileFilter;

public class HTMLFileFilter extends FileFilter {
  @Override
  public boolean accept(File f) {

    if (f.isDirectory()) return true;
    else {
      if (f.getName().toLowerCase().endsWith(".html") || f.getName().toLowerCase().endsWith(".htm"))
        return true;
    }
    return false;
  }

  @Override
  public String getDescription() {
    return "HTML и HTM файлы";
  }
}
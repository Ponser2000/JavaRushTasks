package com.javarush.task.task32.task3209;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringReader;
import java.io.StringWriter;
import javax.swing.JFileChooser;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class Controller {

  private View view;
  private HTMLDocument document;
  private File currentFile;

  public Controller(View view) {
    this.view = view;
  }

  public void init() {
    createNewDocument();
  }

  public HTMLDocument getDocument() {
    return document;
  }

  public void exit() {
    System.exit(0);
  }

  public void resetDocument() {
    if (document != null) {
    
      document.removeUndoableEditListener(view.getUndoListener());
    }

    document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
    document.addUndoableEditListener(view.getUndoListener());
    view.update();
  }

  public void setPlainText(String text) {
    resetDocument();
    StringReader stringReader = new StringReader(text);
    try {
      new HTMLEditorKit().read(stringReader, document, 0);
    } catch (Exception e) {
      ExceptionHandler.log(e);
    }
  }

  public String getPlainText() {
    StringWriter stringWriter = new StringWriter();
    try {
      new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
    } catch (Exception e) {
      ExceptionHandler.log(e);
    }
    return stringWriter.toString();
  }

  public void createNewDocument() {
    view.selectHtmlTab();
    resetDocument();
    view.setTitle("HTML редактор");
    currentFile = null;
    view.resetUndo();

  }

  public void openDocument() {
    view.selectHtmlTab();
    JFileChooser jFileChooser = new JFileChooser();
    jFileChooser.setFileFilter(new HTMLFileFilter());
    int choose = jFileChooser.showOpenDialog(view);
    if (choose == JFileChooser.APPROVE_OPTION) {
      currentFile = jFileChooser.getSelectedFile();
      resetDocument();
      view.setTitle(currentFile.getName());
      try {
        FileReader fileReader = new FileReader(currentFile);
        new HTMLEditorKit().read(fileReader, document, 0);
        view.resetUndo();

      } catch (Exception e) {
        ExceptionHandler.log(e);
      }
    }
  }

  public void saveDocument() {
    if (currentFile == null) saveDocumentAs();
    else {
      view.selectHtmlTab();
      view.setTitle(currentFile.getName());

      try {
        FileWriter fileWriter = new FileWriter(currentFile);
        new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
      } catch (Exception e) {
        ExceptionHandler.log(e);
      }

    }
  }

  public void saveDocumentAs() {
    view.selectHtmlTab();
    JFileChooser jFileChooser = new JFileChooser();
    jFileChooser.setFileFilter(new HTMLFileFilter());
    int choose = jFileChooser.showSaveDialog(view);
    if (choose == JFileChooser.APPROVE_OPTION) {
      currentFile = jFileChooser.getSelectedFile();
      view.setTitle(currentFile.getName());
      try {
        FileWriter fileWriter = new FileWriter(currentFile);
        new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
      } catch (Exception e) {
        ExceptionHandler.log(e);
      }
    }
  }

  

  public static void main(String[] args) {
    View view = new View();
    Controller controller = new Controller(view);
    view.setController(controller);
    view.init();
    controller.init();

  }

}

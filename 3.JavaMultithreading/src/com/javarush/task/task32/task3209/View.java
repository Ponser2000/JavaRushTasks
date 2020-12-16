package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.actions.RedoAction;
import com.javarush.task.task32.task3209.actions.UndoAction;
import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.undo.UndoManager;

public class View extends JFrame implements ActionListener {

  private Controller controller;

  private JTabbedPane tabbedPane = new JTabbedPane();
  private JTextPane htmlTextPane = new JTextPane();
  private JEditorPane plainTextPane = new JEditorPane();

  private UndoManager undoManager = new UndoManager();
  private UndoListener undoListener = new UndoListener(undoManager);
  private RedoAction redoAction = new RedoAction(this);
  private UndoAction undoAction = new UndoAction(this);

  public Controller getController() {
    return controller;
  }

  public View() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      ExceptionHandler.log(e);
    }
  }

  public void setController(Controller controller) {
    this.controller = controller;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "Новый":
        controller.createNewDocument();
        break;
      case "Открыть":
        controller.openDocument();
        break;
      case "Сохранить":
        controller.saveDocument();
        break;
      case "Сохранить как...":
        controller.saveDocumentAs();
        break;
      case "Выход":
        controller.exit();
        break;
      case "О программе":
        showAbout();
    }
  }

  public void init() {
    initGui();
    FrameListener frameListener = new FrameListener(this);
    addWindowListener(frameListener);
    setVisible(true);
  }


  public void exit() {
    controller.exit();
  }

  public void initMenuBar() {
    JMenuBar jMenuBar = new JMenuBar();
    MenuHelper.initFileMenu(this, jMenuBar);
    MenuHelper.initEditMenu(this, jMenuBar);
    MenuHelper.initStyleMenu(this, jMenuBar);
    MenuHelper.initAlignMenu(this, jMenuBar);
    MenuHelper.initColorMenu(this, jMenuBar);
    MenuHelper.initFontMenu(this, jMenuBar);
    MenuHelper.initHelpMenu(this, jMenuBar);
    getContentPane().add(jMenuBar, BorderLayout.NORTH);
  }

  public void initEditor() {
    htmlTextPane.setContentType("text/html");
    JScrollPane jScrollPaneHTML = new JScrollPane(htmlTextPane);
    JScrollPane jScrollPanePlain = new JScrollPane(plainTextPane);

    tabbedPane.addTab("HTML", jScrollPaneHTML);
    tabbedPane.addTab("Текст", jScrollPanePlain);

    Dimension dimension = new Dimension(100, 100);
    tabbedPane.setPreferredSize(dimension);

    tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
    getContentPane().add(tabbedPane, BorderLayout.CENTER);


  }

  public void initGui() {
    initMenuBar();
    initEditor();
    pack();
  }
  

  public boolean canUndo() {
    return undoManager.canUndo();
  }

  public UndoListener getUndoListener() {
    return undoListener;
  }

  public boolean canRedo() {
    return undoManager.canRedo();
  }

  public void undo() {
    try {
      undoManager.undo();
    } catch (Exception e) {
      ExceptionHandler.log(e);
    }
  }

  public void redo() {
    try {
      undoManager.redo();
    } catch (Exception e) {
      ExceptionHandler.log(e);
    }
  }

  public void resetUndo() {
    try {
      undoManager.discardAllEdits();
    } catch (Exception e) {
      ExceptionHandler.log(e);
    }
  }

  public void selectedTabChanged() {
    switch (tabbedPane.getSelectedIndex()) {
      case 0:
        controller.setPlainText(plainTextPane.getText());
        break;
      case 1:
        plainTextPane.setText(controller.getPlainText());
        break;
    }
    resetUndo();
  }

  public boolean isHtmlTabSelected() {
    return tabbedPane.getSelectedIndex() == 0;
  }

  public void selectHtmlTab() {
    tabbedPane.setSelectedIndex(0);
    resetUndo();

  }

  public void update() {
    htmlTextPane.setDocument(controller.getDocument());
  }


  public void showAbout() {
    JOptionPane.showMessageDialog(getContentPane(), "It hard to be God", "Information",
        JOptionPane.INFORMATION_MESSAGE);
  }

}

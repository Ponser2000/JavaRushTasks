package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;
import java.awt.Component;
import javax.swing.JMenu;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class TextEditMenuListener implements MenuListener {

  private View view;

  public TextEditMenuListener(View view) {
    this.view = view;
  }

  @Override
  public void menuSelected(MenuEvent e) {
    JMenu menu = (JMenu) e.getSource();
    Component[] components = menu.getMenuComponents();
    for (Component component : components){
      component.setEnabled(view.isHtmlTabSelected());
    }}

  @Override
  public void menuDeselected(MenuEvent e) {

  }

  @Override
  public void menuCanceled(MenuEvent e) {

  }
}

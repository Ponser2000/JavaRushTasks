package com.javarush.task.task32.task3209.actions;

import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

public class SuperscriptAction extends StyledEditorKit.StyledTextAction {

  public SuperscriptAction() {
    super(StyleConstants.Superscript.toString());
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JEditorPane editorPane = getEditor(e);
    if (editorPane!=null) {
      MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editorPane).getInputAttributes();
      SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
      StyleConstants.setSuperscript(simpleAttributeSet,!StyleConstants.isSuperscript(mutableAttributeSet));
      setCharacterAttributes(editorPane,simpleAttributeSet,false);
    }
  }
}

package oopCh7;

import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class TextAreaDemo extends Frame {
    TextField tf;    TextArea ta;

    public TextAreaDemo() {
        super("TextAreaDemo");

        Panel panel = new Panel();
        tf = new TextField ("http://", 20);
        ta = new TextArea ("Hi, Friends!\n", 4, 30);
        ta.setEditable(false);
        panel.add(new Label("URL : "));
        panel.add(tf);
        panel.add(ta);

        add(panel);
        setSize(250,150);
        setVisible(true);
    }
    void doSomething() {
        ta.append("default url = "+ tf.getText() + "\n");
        tf.setText(tf.getText() + "www.javasoft.com");
        tf.setCaretPosition(tf.getText().length());
        ta.append("input url = "+ tf.getText() + "\n");
    }
 
public static void main (String args[]) {
        new TextAreaDemo().doSomething();
    }
}
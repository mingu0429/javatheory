package oopCh7;

import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class TextFieldDemo extends Frame{
	TextField tf1, tf2;
	public TextFieldDemo() {
		super("TextFieldDemo");
		Panel panel = new Panel();
		tf1 = new TextField(20);
		tf2 = new TextField("http://",20);
		tf1.setEchoChar('*');
		panel.add(new Label("password"));
		panel.add(tf1);
		panel.add(new Label("address"));
		panel.add(tf2);
		add(panel);
		setSize(200,150);
		setVisible(true);
	}
	void doSomething() {
		tf1.setText("ㄶㅇ바보");
		System.out.println(tf1.getText());
		System.out.println(tf2.getText());
	}
	public static void main(String[] args) {
		new TextFieldDemo().doSomething();
	}
}

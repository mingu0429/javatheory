package oopCh7;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEvent_19a extends Frame implements ActionListener{
	TextArea textarea;
	Button button;
	ButtonEvent_19a(String title) {
super(title);
textarea = new TextArea("Welcome!\nEvent handling using a nested class...");
button = new Button(" OK ");
//ButtonListener19 butner = new ButtonListener19();
button.addActionListener(this);
add("Center",textarea);
Panel p = new Panel();
p.add(button);
add("South",p);
setSize(300,150);
setVisible(true);
	}
	//class ButtonListener19 implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			textarea.append("\nI hear ..."+ ((Button)e.getSource()).getActionCommand());
		}
	//}
	public static void main(String[] a) {
		new ButtonEvent_19a("ButtonEvent_19anested class");
	}
}

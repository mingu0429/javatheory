package oopCh7;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;

public class TestLabel extends Frame {
	public TestLabel(String title){
		super(title);
		setBackground(Color.lightGray);
		setLayout(new FlowLayout());
		Label al = new Label("Label");
		add(al);
        Label biggerlabel = new Label("혜미미");
        biggerlabel.setFont(new Font("Helvetica", Font.BOLD, 24));
        biggerlabel.setBackground(Color.white);
        add(biggerlabel);

		setSize(300,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TestLabel("TestAWT22");
	}
}

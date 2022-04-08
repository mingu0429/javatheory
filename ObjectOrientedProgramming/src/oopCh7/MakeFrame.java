package oopCh7;

import java.awt.Color;
import java.awt.Frame;

public class MakeFrame {
public static void main(String[] args) {
	Frame f = new Frame("title");
	f.setBackground(
			Color.lightGray);
	f.setSize(300,200);
	f.setVisible(true);
}
}

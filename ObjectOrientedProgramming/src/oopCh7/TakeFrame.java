package oopCh7;

import java.awt.Color;
import java.awt.Frame;

public class TakeFrame extends Frame{
	TakeFrame(String title){
		super(title);
		setBackground(Color.LIGHT_GRAY);
		setSize(300,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TakeFrame("타이틀");
	}
}
package oopCh7;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class Keyboard_flow extends Frame{
	public Keyboard_flow() {
		super("Trash Keyboard");
		setLayout(new FlowLayout());
		Button[] btn =  new Button[27];
		String key[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","ENTER"};
		for(int i=0; i< key.length;i++) {
			btn[i] = new Button(key[i]);
			add(btn[i]);
		}
		setSize(280,120);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Keyboard_flow();
	}
}

package oopCh7;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.TextField;

public class ScrollPaneDemo extends Frame{
	ScrollPane spane;
	Panel panel, ta, btn;
	
	public ScrollPaneDemo() {
		super("Scroll Pane Test");
		spane = new ScrollPane();
		spane.setSize(200,150);
		
		panel = new Panel();
		panel.setSize(300,200);
		panel.setLayout(new BorderLayout());
		ta = new Panel();
		ta.setLayout(new BorderLayout());
		ta.add("Center",new TextArea());
		ta.add("South",new TextField());
		panel.add("Center", ta);
		
		btn = new Panel();
		btn.add(new Button("OK"));
		btn.add(new Button("CANCEL"));
		panel.add("South",btn);
		
		spane.add(panel);
		add("Center",spane);
	}
	public static void main(String[] args) {
		ScrollPaneDemo spdemo = new ScrollPaneDemo();
		spdemo.setSize(200,150);
		spdemo.setVisible(true);
	}

}

package oopCh7;

import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ListActive extends Frame implements ItemListener, ActionListener{
	public ListActive() {
		super("ListActive");
		Panel panel = new Panel();
		List list = new List(4, false);
		String msg[] = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };
		for(int i = 0; i<msg.length;i++) {
			list.add(msg[i]);
		}
		list.addItemListener(this);
		list.addActionListener(this);
		panel.add(list);
		add(panel);
		setSize(150,100);
		setVisible(true);
	}
	public void itemStateChanged(ItemEvent e) {
		System.out.println("Item chosen: "+((List)e.getSource()).getSelectedItem());
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("Action for "+((List)e.getSource()).getSelectedItem());
	}
	public static void main(String[] args) {
		new ListActive();
	}
}

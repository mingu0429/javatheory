package oopCh8;

import javax.swing.*;	import java.awt.event.*;	import java.awt.*;
public class SimplestJFrame extends JPanel {
    JButton btn;
    SimplestJFrame () {
         String btn_name = "Delete?";
         ImageIcon btn_icon= new ImageIcon("img/수지.png" /*"okay.gif"*/);
         btn = new JButton (btn_name, btn_icon);
         btn.addActionListener (new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 //setBackground (Color.yellow);
		 btn.setBackground(new Color((int)(Math.random()*255), 
			(int)(Math.random()*255), (int)(Math.random()*255)));
             }
         });
	 add(btn);
    }
    public static void main (String[] args) {
	JFrame jf= new JFrame("핵심 Java:SwMVCbutton Ex 1");
	jf.getContentPane().add(new SimplestJFrame());
	//jf.pack();
	jf.setSize(300, 150);
	jf.setVisible(true);
    }
}

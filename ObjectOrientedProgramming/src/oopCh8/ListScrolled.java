package oopCh8;

/** filename : ListScrolled.java 핵심 Java 8장 실습 8.4 */
import javax.swing.*;
import javax.swing.event.*;
public class ListScrolled extends JPanel {
      ListScrolled() {
	String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday",
	         "Thursday", "Friday", "Saturday" };
 	JList daylist = new JList (days);
	daylist.setVisibleRowCount(4);
	daylist.addListSelectionListener(new ListSelectionListener() {
	         public void valueChanged(ListSelectionEvent e) {
		System.out.println((String)((JList)e.getSource()).getSelectedValue());
	        }
	});
	JScrollPane sp = new JScrollPane (daylist);
	//add(new JLabel(new ImageIcon("image/LeHuitiemeJour.jpg")));
	add(sp);
      }
      public static void main(String[] args) {
	JFrame jf = new JFrame("핵심 Java: ListScrolled");
	jf.getContentPane().add(new ListScrolled());
	jf.pack();
	jf.setVisible(true);
     }
}
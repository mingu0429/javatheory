package oopCh8;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestCombo extends JFrame {
    JComboBox jc0, jc;
    TestCombo() {
	super("핵심 Java: TestCombo 실습 8.3");
	String[] words = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
	jc0 = new JComboBox(words);
	jc = new JComboBox(words);
	jc.setMaximumRowCount(5);	
	JPanel jp = new JPanel();
	jp.add(jc0);
	jp.add(jc);
	getContentPane().add(jp);
	pack();	//Causes this Window to be sized to fit the preferred size and layouts of its subcomponents.
	setVisible(true);
    }
    void simulate_Combo(){
	System.out.println("전체 item 수 = " + jc.getItemCount());
	System.out.println("3번 item = " + (String) jc.getItemAt(3));
	jc.setSelectedIndex(4);
	System.out.println("선택(4) " + (String) jc.getSelectedItem());
    }
	
    public static void main(String[] args){
	TestCombo tc = new TestCombo();
	tc.simulate_Combo();
    }
}

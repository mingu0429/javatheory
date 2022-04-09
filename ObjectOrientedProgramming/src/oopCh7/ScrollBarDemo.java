package oopCh7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.TextField;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ScrollBarDemo extends Frame implements AdjustmentListener {
	Scrollbar hsb;
	TextField tf;
	int value;

	public ScrollBarDemo() {
		super("스크롤바데모");
		setLayout(new BorderLayout(5, 5));
		setBackground(Color.yellow);
		hsb = new Scrollbar(Scrollbar.HORIZONTAL, 70, 25, 0, 200 + 25);
		hsb.addAdjustmentListener(this);
		add("North", new Label("-* 스크롤바 데모: Value Chooser *-", Label.CENTER));
		add("West", new Label("  0"));
		add("Center", hsb);
		add("East", new Label("200"));
		tf = new TextField(20);
		tf.setEditable(false);
		add("South", tf);
		value = hsb.getValue();
		tf.setText("Min/Max = " + hsb.getMinimum() + "/" + hsb.getMaximum() + ", value = " + hsb.getValue()
				+ ", bubble size = " + hsb.getVisibleAmount());
		setSize(300, 100);
		setVisible(true);
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		tf.setText("Value = "+ e.getValue());
	}
	public static void main(String[] args) {
		new ScrollBarDemo();
	}
}

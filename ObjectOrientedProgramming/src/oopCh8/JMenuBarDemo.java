package oopCh8;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JMenuBarDemo extends JFrame {
	JMenuBar mbar;
	JMenu mFile, mEdit, mHelp, mDraw, mFill, pmColor;
	JMenuItem fnew, fopen, fsave, fexit;
	JCheckBoxMenuItem line, rect, circle, red, yellow, blue;
	JTextArea tarea;
	JPopupMenu popup;
	
	public JMenuBarDemo() {
		super("핵심 Java: JMenuBarDemo()");
		mbar = new JMenuBar();
		setJMenuBar(mbar);
		
		mFile = new JMenu("File");
		fnew= new JMenuItem("New");
		fopen = new JMenuItem("Open");
		fsave = new JMenuItem("Save");
		fexit = new JMenuItem("Exit");
		mFile.add(fnew);
		mFile.add(fopen);
		mFile.add(fsave);
		mFile.addSeparator();
		mFile.add(fexit);
		mEdit = new JMenu("Edit");
		mDraw = new JMenu("Draw");
		circle = new JCheckBoxMenuItem("Circle");
		rect = new JCheckBoxMenuItem("Rectangle");
		line = new JCheckBoxMenuItem("line");
		mDraw.add(circle);
		mDraw.add(rect);
		mDraw.add(line);
		mEdit.add(mDraw);
		mFill= new JMenu("Fill");
		red = new JCheckBoxMenuItem("Red");
		yellow = new JCheckBoxMenuItem("Yellow");
		blue = new JCheckBoxMenuItem("Blue");
		mFill.add(red);
		mFill.add(yellow);
		mFill.add(blue);
		mEdit.add(mFill);
		mHelp= new JMenu("Help");
		mbar.add(mFile);
		mbar.add(mEdit);
		mbar.add(mHelp);
		
		tarea = new JTextArea("Hello!",10,25);
		JScrollPane sp = new JScrollPane(tarea);
		getContentPane().add(sp,"Center");
		
		popup = new JPopupMenu("Popup Menu");
		popup.add(new JPopupMenu("copy"));
		popup.add(new JPopupMenu("cut"));
		popup.addSeparator();
		pmColor = new JMenu("color");
		pmColor.add(new JMenuItem("white"));
		pmColor.add(new JMenuItem("black"));
		popup.add(pmColor);
		tarea.addMouseListener(new PopupListener());
		
		setSize(300,200);
		setVisible(true);
	}
	class PopupListener extends MouseAdapter{
		public void mouseReleased(MouseEvent e) {
			if(e.isPopupTrigger())
				popup.show(e.getComponent(),e.getX(),e.getY());
		}
	}public static void main(String[] args) {
		new JMenuBarDemo();
	}
}

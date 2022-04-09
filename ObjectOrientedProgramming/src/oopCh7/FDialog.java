package oopCh7;

import java.awt.*;
import java.awt.event.*;

class FDialog extends Frame implements ActionListener 
{
    TextField tfield;
    Button load;
    FileDialog fdialog;
	
    public FDialog() 
    {
        setLayout(new BorderLayout());
        Panel panel = new Panel();		
        load = new Button("Load");
        load.addActionListener(this);
        panel.add(load);
        add("Center", panel);
        tfield = new TextField();
        add("South", tfield);
    }
    public static void main (String[] args) 
    {
        FDialog loadfile = new FDialog();
        loadfile.setSize(300, 100);
        loadfile.setVisible(true);
		
        loadfile.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0); // 프로그램 종료
            }
        });		
    }
	
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource()==load) {
            fdialog = new FileDialog(this, "Load File..", FileDialog.LOAD);
            fdialog.setVisible(true);
            String fname = fdialog.getFile();
            tfield.setText(fname);			
        }
    }
}

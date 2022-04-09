package oopCh8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingEd extends JFrame {
	JTextPane tpane;
	JToolBar tbar;

	SwingEd() {
		super("SwingEd"); // 부모클래스의 생성자 JFrame(“SwingEd”) 호출
		getContentPane().setLayout(new BorderLayout());
		setMenuBar();
		setToolBar();
		setTextPane();
	}

	void setMenuBar() {
		JMenuBar mbar = new JMenuBar(); // 메뉴바 생성
		JMenu mFile = new JMenu("File"); // 메뉴(file) 생성
		mFile.add(new JMenuItem("New", 'N')); // 메뉴(file)에 아이템(new) 추가
		mFile.add(new JMenuItem("Open", 'O')); // 메뉴(file)에 아이템(open) 추가
		mFile.add(new JMenuItem("Save", 'S')); // 메뉴(file)에 아이템(save) 추가
		mFile.addSeparator(); // 메뉴(file)에 구분자 추가
		mFile.add(new JMenuItem("Exit", 'X')); // 메뉴(file)에 아이템(종료) 추가
		mbar.add(mFile); // 메뉴바에 메뉴(file) 추가
		mbar.add(Box.createHorizontalGlue());
		JMenu mHelp = new JMenu("Help"); // 메뉴(help) 생성
		mHelp.add(new JMenuItem("About")); // 메뉴(help)에 아이템(about) 추가
		mbar.add(mHelp); // 메뉴바에 메뉴(help) 추가
		setJMenuBar(mbar); // 프레임에 메뉴바 추가
	}

	void setToolBar() {
		tbar = new JToolBar(JToolBar.HORIZONTAL); // 툴바 생성
		tbar.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1)); // 툴바 레이아웃 설정
		JButton jbtn; // 툴바에 붙일 버튼 선언
		JComboBox jcbox; // 툴바에 붙일 콤보박스 선언
		jbtn = new JButton(new ImageIcon("img/New.gif")); // 버튼(new) 생성
		jbtn.setAlignmentY(0.5f); // Y축으로 버튼(new) 위치 조정
		tbar.add(jbtn); // 툴바에 버튼(new) 추가
		jbtn = new JButton(new ImageIcon("img/Open.gif")); // 버튼(open) 생성
		jbtn.setAlignmentY(0.5f); // Y축으로 버튼(open) 위치 조정
		tbar.add(jbtn); // 툴바에 버튼(open) 추가
		jbtn = new JButton(new ImageIcon("img/Save.gif")); // 버튼(save) 생성
		jbtn.setAlignmentY(0.5f); // Y축으로 버튼(save) 위치 조정
		tbar.add(jbtn); // 툴바에 버튼(save) 추가
		String[] fontnames = { "바탕체", "돋움체", "굴림체" }; // 콤보박스에 들어갈 문자
		jcbox = new JComboBox(fontnames); // 콤보박스 생성
		jcbox.setAlignmentY(0.5f); // 콤보박스 위치 조정
		tbar.add(jcbox); // 툴바에 콤보박스 추가

		String[] fontsizes = { "8", "10", "12", "14", "18", "24" }; // 콤보박스에 들어갈 문자
		jcbox = new JComboBox(fontsizes); // 콤보박스 생성
		jcbox.setSelectedIndex(2); // 기본값 설정
		jcbox.setAlignmentY(0.5f); // 콤보박스 위치 조정
		tbar.add(jcbox); // 툴바에 콤보박스 추가

		tbar.setFloatable(true); // 떠다니기
		getContentPane().add(tbar, BorderLayout.NORTH); // 프레임에 툴바 추가
	}

	void setTextPane() {
		tpane = new JTextPane(); // 텍스트 패널 생성
		getContentPane().add(new JScrollPane(tpane), BorderLayout.CENTER);
		// 프레임에 삽입
	}

	public static void main(String[] args) { // 메인함수, 프로그램은 여기서부터 시작
		SwingEd swed = new SwingEd(); // 지금까지 우리가 만들었던 객체를 실제 생성
		swed.addWindowListener(new WindowAdapter() { // 종료기능
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		swed.pack();
		swed.setSize(400, 300);
		swed.setVisible(true);
	}
}
package com.test02;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Layout02 implements ActionListener {

	Frame frame;
	Button btn01;
	Button btn02;
	Button btn03;
	Button btn04;
	CardLayout card;
	
	public Layout02() {
		frame = new Frame("CardLayoutExample");
		card = new CardLayout();
		frame.setLayout(card);
		
		btn01 = new Button("ù��° ��ư");
		btn02 = new Button("�ι�° ��ư");
		btn03 = new Button("����° ��ư");
		btn04 = new Button("�׹�° ��ư");
	}
	
	public void go() {
		
		// frame�� ��ư �ø���
		frame.add("1", btn01);
		frame.add("2", btn02);
		frame.add("3", btn03);
		frame.add("4", btn04);
		
		// event �ɾ��ֱ�
		addListener();
		
		// x ������ ����
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// frame Ȱ��ȭ
		frame.setSize(200,200);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		card.next(frame);
	}
	
	private void addListener() {
		btn01.addActionListener(this);
		btn02.addActionListener(this);
		btn03.addActionListener(this);
		btn04.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new Layout02().go();
	}
}


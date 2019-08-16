package com.test03;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// 1. ��ư�� ������ �ش� ��ư�� text�� console�� ���
// 2. x ��ư ������ ����
public class FrameTest01 extends Frame {
	
	Button btn;
	
	public FrameTest01() {
		btn = new Button("click me");
	}
	
	public void go() {
		add(btn);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());				
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setSize(200,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrameTest01().go(); // heap�� ��ü ����.
	}
	
	
}

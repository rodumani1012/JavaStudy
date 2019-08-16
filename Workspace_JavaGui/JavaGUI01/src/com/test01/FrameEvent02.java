package com.test01;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// �̺�Ʈ ���ǹ�� 2 
// innerClass�� ���� �̺�Ʈ�� ����(�̺�Ʈ�� ���� �� ���� ���)
public class FrameEvent02 extends Frame {
	
	Button btn;
	
	public FrameEvent02() {
		btn = new Button("click me!");
	}
	
	public void go() {
		this.add(btn);
		
		btn.addActionListener(new MyEvent());
		
		setSize(200,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		FrameEvent02 f = new FrameEvent02();
		f.go();
	}
	
	// innerClass
	class MyEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
		}
	}
}

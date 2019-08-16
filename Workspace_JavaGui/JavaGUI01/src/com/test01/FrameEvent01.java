package com.test01;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// �̺�Ʈ ���� ��� 1 : this
public class FrameEvent01 extends Frame implements ActionListener{

	Button btn;
	int cnt = 1;
	
	public FrameEvent01() {
		btn = new Button("push");
	}
	
	public void go() {
		add(btn);
		
		btn.addActionListener(this); // Ŭ���� ������ actionPerformed �޼ҵ尡 ���� ��
		
		setSize(200,200);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand()); // ��ư�� �� ����
		System.out.println(e.getSource()); //�̺�Ʈ�� ������� ��ü(ó�� ����������� button0)
		System.out.println(e.getID());	//�̺�ƮŸ�� (clickEvent�� 1001)
		System.out.println(e.toString());
		System.out.println("--------");
		
		Button b = (Button)e.getSource();
		System.out.println(b.getLabel()); // ��ư�� �� ����.
		System.out.println(b.getName());
		System.out.println(b.getSize());
		
		b.setLabel(""+ cnt++);
	}
	
	public static void main(String[] args) {
		FrameEvent01 f = new FrameEvent01();
		f.go();
	}
}

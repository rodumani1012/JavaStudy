package com.test01;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// �̺�Ʈ ���� ��� 4.
//	�θ��� �޼ҵ���� ��ӹ޾Ƽ� �ʿ��� �͸� ���
public class FrameEvent04 extends Frame implements WindowListener{
	
	Button btn ;
	
	public FrameEvent04() {
		btn = new Button("Ŭ��!!");
		go();
	}

	private void go() {
		add(btn);
		
		// �տ� this: frame	 ���� this : windowListener
		this.addWindowListener(this);
		
		setSize(200,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrameEvent04();
	}

	@Override
	public void windowOpened(WindowEvent e) { // ó�� ������ ��
		System.out.println("windowOpened");
	}

	@Override
	public void windowClosing(WindowEvent e) { // X��ư
		System.out.println("windowClosing");
		System.exit(0); // X��ư���� �ݾ��� �� ������ ��.
		
	}

	@Override
	public void windowClosed(WindowEvent e) { 
		System.out.println("windowClosed");
		
	}

	@Override
	public void windowIconified(WindowEvent e) { // �ּ�ȭ
		System.out.println("windowIconified");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) { // �ּ�ȭ �ݴ�
		System.out.println("windowDeiconified");
		
	}

	@Override
	public void windowActivated(WindowEvent e) { // Ȱ��ȭ(���� ���� ���� ��)
		System.out.println("windowActivated");
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) { // ��Ȱ��ȭ(�ٸ��� ���� ���� ��)
		System.out.println("windowDeactivated");
		
	}
}

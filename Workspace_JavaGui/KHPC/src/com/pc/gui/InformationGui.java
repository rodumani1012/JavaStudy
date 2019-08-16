package com.pc.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InformationGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 1.�ʵ忡�� ����
	JLabel label_myid, label_mypw, label_myname, label_mydob,
			label_myaddr, label_mytel;
	JTextField txt_myid, txt_mypw, txt_myname, txt_mydob,
			txt_myaddr, txt_mytel;
	JButton update, close;
	JPanel p, p1, p2, p3, p4, p5, p6;

	// 2.�⺻������
	public InformationGui() {
		super("ȸ������");
		p = new JPanel();
		label_myid = new JLabel("��   ��   �� : ");
		txt_myid = new JTextField(10);

		p1 = new JPanel();
		label_mypw = new JLabel("��й�ȣ : ");
		txt_mypw = new JTextField(10);

		p2 = new JPanel();
		label_myname = new JLabel("��         �� : ");
		txt_myname = new JTextField(10);

		p3 = new JPanel();
		label_mydob = new JLabel("������� : ");
		txt_mydob = new JTextField(10);

		p4 = new JPanel();
		label_myaddr = new JLabel("��         �� : ");
		txt_myaddr = new JTextField(10);

		p5 = new JPanel();
		label_mytel = new JLabel("��ȭ��ȣ : ");
		txt_mytel = new JTextField(10);

		p6 = new JPanel();
		update = new JButton("����");
		close = new JButton("�ݱ�");
		
	}
	
	public void go() {
		setLayout(new GridLayout(7,1));
		
		p.add(label_myid);
		p.add(txt_myid);
		
		p1.add(label_mypw);
		p1.add(txt_mypw);
		
		p2.add(label_myname);
		p2.add(txt_myname);
		
		p3.add(label_mydob);
		p3.add(txt_mydob);
		
		p4.add(label_myaddr);
		p4.add(txt_myaddr);
		
		p5.add(label_mytel);
		p5.add(txt_mytel);
		
		p6.add(update);
		p6.add(close);
		
		add(p);
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(p5);
		add(p6);
		
		setSize(400, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new InfomationGui().go();
	}
}

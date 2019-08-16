package com.test03;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * 1. TextField�� ���� �Է��ϰ� enter ġ�� ���� ��Ŀ���� �̵�
 * (�̸� -> �ּ� -> ��ȭ��ȣ -> �̸� -> �ּ�....)
 * hint : KeyEvent.VK_ENTER, requestFocus();
 * 
 * 2. Ȯ�� ��ư Ŭ���ϸ� tAreas�� ��ü ���� ���
 * 
 * 3. ��� ��ư Ŭ���ϸ� TextField�� �ִ� �� ��� ����
 * 
 * 4. ���� ��ư Ŭ���ϸ� tAreas�� �ִ� ��ü ���� ����
 */
public class FrameTest02 extends Frame {
	
	Panel p01;
	Panel p02;
	Label lbName, lbAddr, lbTel;
	
	TextField txtName, txtAddr, txtTel;
	
	TextArea tAreas;
	
	Button btnOk, btnCn, btnRe;
	
	CheckboxGroup cbg;
	Checkbox c01;
	Checkbox c02;
	
	public FrameTest02() {
		p01 = new Panel();
		lbName = new Label("��  ��");
		lbAddr = new Label("��  ��");
		lbTel = new Label("��ȭ��ȣ");
		
		txtName = new TextField(30);
		txtAddr = new TextField(30);
		txtTel = new TextField(30);
		
		cbg = new CheckboxGroup();
		c01 = new Checkbox("����", cbg, true);
		c02 = new Checkbox("����", cbg, false);
		
		btnOk = new Button("Ȯ��");
		btnCn = new Button("���");
		
		p02 = new Panel();
		tAreas = new TextArea(5,35);
		btnRe = new Button("����");
		
	}
	
	public void go() {
		
		this.setLayout(new GridLayout(2,1));
		
		// p01
		p01.setLayout(new GridLayout(5,2));
		p01.add(lbName);
		p01.add(txtName);
		
		p01.add(lbAddr);
		p01.add(txtAddr);
		
		p01.add(lbTel);
		p01.add(txtTel);
		
		p01.add(c01);
		p01.add(c02);
		
		p01.add(btnOk);
		p01.add(btnCn);
		
		
		// p02
		p02.add(tAreas);
		p02.add(btnRe);
		
		// event
		txtName.addKeyListener(new KeyAdapter() { // �̸����� �ּҷ� Ŀ�� �̵�
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					txtAddr.requestFocus();
				}
			}
		});
		
		txtAddr.addKeyListener(new KeyAdapter() { // �ּҿ��� ��ȭ��ȣ�� Ŀ�� �̵�
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					txtTel.requestFocus();
				}
			}
		});
		
		txtTel.addKeyListener(new KeyAdapter() { // ��ȭ��ȣ���� �̸����� Ŀ�� �̵�
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					txtName.requestFocus();
				}
			}
		});
		
		MyEvent actionEvent = new MyEvent();
		btnOk.addActionListener(actionEvent);
		btnCn.addActionListener(actionEvent);
		btnRe.addActionListener(actionEvent);

		this.addWindowListener(new WindowAdapter() {
			// WindowAdapter()�� �ʿ��� �ֵ鸸 �������̵� �� �� �ְ� �������.
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// frame�� panel �ø���
		add(p01);
		add(p02);
		
		setSize(300,300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new FrameTest02().go();
	}
	
	class MyEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) { //��ư Ŭ���ϸ� �̺�Ʈ �ɰ� ���� ��
			Button btn = (Button)e.getSource();
			
			System.out.println(btn);
			if(btn.getLabel().equals("Ȯ��")) {
				String res = "";
				if (c01.getState()) {
					res = c01.getLabel();
				} else if(c02.getState()) {
					res = c02.getLabel();
				}
				
				res += "[" + txtName.getText() + "]";
				res += "\t" + txtAddr.getText();
				res += "\t" + txtTel.getText();
				tAreas.append(res + "\n");
				
			} else if (btn.getLabel().equals("���")) {
				txtName.setText("");
				txtAddr.setText("");
				txtTel.setText("");
			} else if (btn.getLabel().equals("����")) {
				txtName.setText("");
				txtAddr.setText("");
				txtTel.setText("");
				tAreas.setText("");
				tAreas.append("");
			}
			
		}	
	}
}

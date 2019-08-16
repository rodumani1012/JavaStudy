package com.test01;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameEventTest extends Frame{

	Panel p01, p02, p03, p04;
	Checkbox c01, c02, c03;
	
	// awt���� radiobox�� ���� ���, CheckboxGroup���� ��� ����Ѵ�.
	CheckboxGroup cbg;
	
	Choice cc;
	List lst; // java.utill �� �ƴ� java.awt �� �ִ� List!! 
	TextField tf;
	
	public FrameEventTest() {
		p01 = new Panel();
		p02 = new Panel();
		p03 = new Panel();
		p04 = new Panel();
		
		cbg = new CheckboxGroup();
		c01 = new Checkbox("one", cbg, true);
		c02 = new Checkbox("two", cbg, false);
		c03 = new Checkbox("three", cbg, false);
		
		cc = new Choice();
		lst = new List(5, false); // true/false : �������� ���õ� �� �ִ��������� ����
		tf = new TextField(30);
	}
	
	public void go() {
		
		setLayout(new GridLayout(4,1));
		
		// p01
		p01.add(c01);
		p01.add(c02);
		p01.add(c03);
		
		// p02
		p02.add(cc);
		cc.add("��");
		cc.add("����");
		cc.add("����");
		cc.add("�ܿ�");
		
		// p03
		p03.add(lst);
		lst.add("��");
		lst.add("��");
		lst.add("ȭ");
		lst.add("��");
		lst.add("��");
		lst.add("��");
		lst.add("��");
		
		// p04
		p04.add(tf);
		tf.setEchoChar('*');
		
		// frame�� �г��� �ø���
		add(p01);
		add(p02);
		add(p03);
		add(p04);

		// event ������
		// x ������ ����
		this.addWindowListener(new WindowAdapter() {
			// WindowAdapter()�� �ʿ��� �ֵ鸸 �������̵� �� �� �ְ� �������.
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		MyCheckEvent myEvent = new MyCheckEvent();		
		c01.addItemListener(myEvent);
		c02.addItemListener(myEvent);
		c03.addItemListener(myEvent);
		
		cc.addItemListener(myEvent);
		
		lst.addItemListener(myEvent);
		
		tf.addKeyListener(myEvent);
		
		tf.addTextListener(myEvent);
		
		setSize(400,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrameEventTest().go();
	}
	
	class MyCheckEvent implements ItemListener, KeyListener, TextListener{

	      @Override
	      public void itemStateChanged(ItemEvent e) {
	         System.out.println(e);
	         
	         /*
	         if(e.getStateChange() == ItemEvent.SELECTED) {
	            System.out.println(e.getItem() + " : selected!!");
	         }
	         */
	         
	         /* ClassException ���� �߻�
	         Checkbox ch = (Checkbox)e.getSource();
	         if(ch.getState()) {
	        	 System.out.println(ch.getLabel() + " : üũ");
	         }
	         */
	         
	         /*
	         if(cc.getSelectedItem() == "��") {
	        	 p02.setBackground(Color.pink);
	         } else if(cc.getSelectedItem() == "����") {
	        	 p02.setBackground(Color.red);
	         } else if(cc.getSelectedItem() == "����") {
	        	 p02.setBackground(Color.yellow);
	         } else if(cc.getSelectedItem() == "�ܿ�") {
	        	 p02.setBackground(Color.black);
	         }
	         */
	         
	         // instanceof : �ش� ��ü�� type�� �Ǻ�����
	         if(e.getSource() instanceof Checkbox) {
	        	 System.out.println(((Checkbox)e.getSource()).getLabel() + " : üũ");
	         } else if(e.getSource() instanceof Choice) {
	        	 if(cc.getSelectedItem() == "��") {
	        		 p02.setBackground(Color.pink);
	        	 } else if(cc.getSelectedItem() == "����") {
		        	 p02.setBackground(Color.red);
		         } else if(cc.getSelectedItem() == "����") {
		        	 p02.setBackground(Color.yellow);
		         } else if(cc.getSelectedItem() == "�ܿ�") {
		        	 p02.setBackground(Color.black);
		         }
	         } else if(e.getSource() instanceof List) {
	        	 String[] res = ((List)e.getSource()).getSelectedItems();
	        	 for(String s : res) {
	        		 System.out.println(s + " : select list");
	        	 }
	         } 
	      }

		@Override
		public void keyPressed(KeyEvent e) {
			// keyPressed
			if(e.getKeyChar() == KeyEvent.VK_ENTER) {
				// �Էµ� ���ڰ� ���Ͷ��
				System.out.println(((TextField)e.getSource()).getText());
			}
		}
		
		@Override
		public void keyTyped(KeyEvent arg0) {
//			System.out.println("keyTyped : �հ��� ������ ��");
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
//			System.out.println("keyReleased : �հ��� �� ��");
		}

		@Override
		public void textValueChanged(TextEvent e) {
			if(e.getSource() instanceof TextField) {
				TextField t = (TextField)e.getSource();
				System.out.println(t.getText());
			}
		}
	      
	   }
	
}

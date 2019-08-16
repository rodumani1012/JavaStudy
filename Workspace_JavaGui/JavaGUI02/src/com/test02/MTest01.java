package com.test02;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.test01.FrameTest01;

public class MTest01 extends Frame {
	
	// ��ü ����
	MenuBar mb;
	Menu m_file;
	MenuItem n_frame, n_open, n_save, n_newsave, n_page, n_print, n_end,
		p_open, p_save, p_newsave;
	PopupMenu pm; // ���콺 ��Ŭ�� �Ҷ� ������ �޴�.
	TextArea ta;
	
	// �����ڿ��� �ʵ� �ʱ�ȭ
	public MTest01() {
		m_file = new Menu("����");
		mb = new MenuBar();
		
		// Ű���忡�� ���� ����Ű
		n_frame = new MenuItem("���� �����(N)", new MenuShortcut(KeyEvent.VK_N));
		n_open = new MenuItem("����(O)", new MenuShortcut(KeyEvent.VK_O)); //���� O
		n_save = new MenuItem("����(S)", new MenuShortcut(KeyEvent.VK_S));
		n_newsave = new MenuItem("�ٸ� �̸����� ����");
		n_page = new MenuItem("������ ����");
		n_print = new MenuItem("�μ�");
		n_end = new MenuItem("������(X)", new MenuShortcut(KeyEvent.VK_X));
		
		pm = new PopupMenu("�˾�");
		p_open = new MenuItem("����", new MenuShortcut(KeyEvent.VK_O)); //���� O
		p_save = new MenuItem("����", new MenuShortcut(KeyEvent.VK_S));
		p_newsave = new MenuItem("�ٸ� �̸����� ����");
		
		ta = new TextArea();
	}
	
	public void go() {
		
		// menu ��ü�� menuItem�� �ø���.
		m_file.add(n_frame);
		m_file.add(n_open);
		m_file.add(n_save);
		m_file.add(n_newsave);
		m_file.addSeparator(); // �ٸ��̸����� ����� ���������� ������ ��
		m_file.add(n_page);
		m_file.add(n_print);
		m_file.add("-"); // addSeparator�� ���� ����(�μ�� ������ ������ ��)
		m_file.add(n_end);
		
		// menuBar�� menu�� �ø���.
		mb.add(m_file);
		
		// frame�� menuBar�� �ø���.
		this.setMenuBar(mb);
		
		//--------------------------------
		
		// popupMenu�� menuItem �ø���.
		pm.add(p_open);
		pm.add(p_save);
		pm.add(p_newsave);
		
		// frame�� popupMenu �ø���.
		this.add(pm);
		
		//--------------------------------
		add(ta);
		
		// events
		MTestEvents events = new MTestEvents();
		this.addWindowListener(events); // x��ư ������ ����
		
		n_end.addActionListener(events); // ������(X) ������ ����
		n_frame.addActionListener(events);
		n_open.addActionListener(events);
		
		ta.addKeyListener(events);
		ta.addMouseListener(events);
		ta.addMouseMotionListener(events);
		
		
		// view
		setSize(400,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MTest01().go();
	}
	
	class MTestEvents extends WindowAdapter 
		implements ActionListener, KeyListener, MouseListener, MouseMotionListener {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

		// ���� Ŭ���� ��
		@Override
		public void actionPerformed(ActionEvent e) {
			MenuItem mi = (MenuItem) e.getSource();			
			
			if(mi.getActionCommand().trim().equals("������(X)")) {
				System.exit(0);
			} 
			
			System.out.println(mi.getShortcut().getKey());
			
			switch (mi.getShortcut().getKey()) {
			case KeyEvent.VK_N:
				ta.setText("\0"); // \0�� �ƽ�Ű�ڵ�󿡼� null�� �ǹ�
				ta.setBackground(Color.white);
				break;
			case KeyEvent.VK_O:
				new FrameTest01().go();
				break;
			case KeyEvent.VK_S:
				
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			ta.append("\n" + "Typed key is '" + e.getKeyChar() + "' \n");
			if(e.isShiftDown()) {
				ta.append("-Shift is down!!! \n");
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getButton() == 3) {
				pm.show(ta, e.getX(), e.getY());
			}			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			ta.setBackground(Color.pink);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			ta.setBackground(Color.yellow);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			String str = String.format("x = %3d, y = %3d \n", e.getX(), e.getY());
			ta.append(str);
		}
		
		
	}
}

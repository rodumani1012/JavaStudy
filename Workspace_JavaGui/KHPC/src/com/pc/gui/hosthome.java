package com.pc.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.server.clientserver;

class JPanel01 extends Panel {

	private JButton jButton01;
	private JButton jButton02;
	private JButton jButton03;
	JButton uButton01;
	JButton uButton02;
	JButton uButton03;
	JButton uButton04;
	JButton uButton05;
	JButton uButton06;
	JScrollPane jScrollPane1;
	JTextArea jTextArea;
	JPanel contentPane;

	public JPanel01() {
		setLayout(null);
		setBackground(Color.white);

		jButton01 = new JButton("�ð��߰�");
		jButton01.setSize(200, 40);
		jButton01.setLocation(360, 10);
		add(jButton01);

		jButton02 = new JButton("�� ��");
		jButton02.setSize(200, 40);
		jButton02.setLocation(750, 10);
		add(jButton02);

		jButton03 = new JButton("ä ��");
		jButton03.setSize(200, 40);
		jButton03.setLocation(1140, 10);
		add(jButton03);

		uButton01 = new JButton("1�� PC");
		uButton01.setBounds(150, 143, 250, 250);
		uButton01.setBackground(Color.black);

		add(uButton01);

		uButton02 = new JButton("2�� PC");
		uButton02.setBounds(700, 143, 250, 250);
		uButton02.setBackground(Color.black);

		add(uButton02);

		uButton03 = new JButton("3�� PC");
		uButton03.setBounds(1250, 143, 250, 250);
		uButton03.setBackground(Color.black);

		add(uButton03);

		uButton04 = new JButton("4�� PC");
		uButton04.setBounds(150, 500, 250, 250);
		uButton04.setBackground(Color.black);
		add(uButton04);

		uButton05 = new JButton("5�� PC");
		uButton05.setBounds(700, 500, 250, 250);
		uButton05.setBackground(Color.black);
		add(uButton05);

		uButton06 = new JButton("6�� PC");
		uButton06.setBounds(1250, 500, 250, 250);
		uButton06.setBackground(Color.black);
		add(uButton06);

	}

}

class JPanel02 extends Panel implements ActionListener {
	private JRadioButton rb, rb1;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private ButtonGroup option;
	private JLabel lblNewLabel;
	JButton btn;
	JButton btn1;
	JButton btn2;

	public JPanel02() {

		JLabel icon;

		icon = new JLabel(new ImageIcon("C:\\workspace_JavaGui\\JavaMiniGUI\\������.jpg"));
		icon.setSize(1800, 800);
		add(icon);

		setBackground(Color.white);
		setLayout(null);

		btn = new JButton("���� �˻�");
		btn.setSize(150, 80);
		btn.setLocation(80, 235);
		add(btn);
		btn.addActionListener(this);

		btn1 = new JButton("ȸ������ ��ȸ");
		btn1.setSize(150, 80);
		btn1.setLocation(80, 150);
		add(btn1);
		btn1.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

//   @Override
//   public void actionPerformed(ActionEvent e) {
//      if (e.getSource() == btn1) {
//         Total_Check dia = new Total_Check();
//         dia.setVisible(true);
//         dia.setSize(500, 500);
//         dia.setTitle("���ȸ�� ��ȸ");
//      } else if(e.getSource() == btn) {
//         Condition_search0 search = new Condition_search0();
//         search.setVisible(true);
//         search.setSize(500,500);
//         search.setTitle("���ǰ˻�");
//         
//      }
//   }
}

public class hosthome extends Frame implements Runnable {
	private void setCount(int count) {
		this.count = count;

	}
	Socket serversocket = null;
	Socket socket = null;
	PrintWriter out = null;
	BufferedReader in = null;

	public JPanel01 jPanel01 = null;
	public JPanel02 jPanel02 = null;
	int count;

	public static void main(String[] args) {
		hosthome win = new hosthome();
		win.setTitle("������ ȭ��");

		win.jPanel01 = new JPanel01();
		win.jPanel02 = new JPanel02();

		JTabbedPane jtab = new JTabbedPane();
		jtab.addTab("ȭ��1", win.jPanel01);
		jtab.addTab("ȸ������", win.jPanel02);
		win.add(jtab);

		win.setExtendedState(MAXIMIZED_BOTH);
		win.setVisible(true);
		win.connect("localhost", 9997);

		win.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public void connect(String host, int port) {
		try {
			serversocket = new Socket(host, port);
			out = new PrintWriter(serversocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(serversocket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addMessage(String msg) {
		JPanel01 jp01 = new JPanel01();
		JButton jbutton = new JButton();
		switch (msg.split(" ")[0]) {
		case "ī��Ʈ":

			this.setCount(Integer.parseInt(msg.split(" ")[1].trim()));
			System.out.println();
			if (count == 2) {
				jp01.uButton01.setText("�ٲ�����");
				System.out.println(count);
			}
			if (count == 3) {
				System.out.println("count");
				jp01.uButton02.setText(getName());

			}
			break;
		}

	}

	
}

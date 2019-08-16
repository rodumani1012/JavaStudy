package com.pc.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class clientserver extends JFrame implements Runnable {

	Socket serversocket = null;
	Socket socket = null;
	PrintWriter out = null;
	BufferedReader in = null;
	JButton btn,btn1;
	
	JTextArea jari1,jari2,jari3,jari4,jari5,jari6,outputArea;
	int count;
	

	// Label
	public clientserver() {

	}

	public void setCount(int count) {
		this.count = count;
	}

	public clientserver(String title) {
		super(title);
		setLayout(null);
		outputArea = new JTextArea();

		outputArea.setEditable(false);
		add(outputArea, "Center");
		jari1 = new JTextArea();
		jari1.setBounds(150, 143, 250, 250);
		jari1.setBackground(Color.gray);

		add(jari1);

		jari2 = new JTextArea();
		jari2.setBounds(700, 143, 250, 250);
		jari2.setBackground(Color.gray);

		add(jari2);

		jari3 = new JTextArea();
		jari3.setBounds(1250, 143, 250, 250);
		jari3.setBackground(Color.gray);

		add(jari3);

		jari4 = new JTextArea();
		jari4.setBounds(150, 500, 250, 250);
		jari4.setBackground(Color.gray);

		add(jari4);

		jari5 = new JTextArea();
		jari5.setBounds(700, 500, 250, 250);
		jari5.setBackground(Color.gray);

		add(jari5);

		jari6 = new JTextArea();
		jari6.setBounds(1250, 500, 250, 250);
		jari6.setBackground(Color.gray);

		add(jari6);



	}

	public void addMessage(String msg) {
		int[] use = {0,0,0,0,0,0};

		String[] msgArr = msg.split(" ");
		String hand = "";
		for (int i = 1; i < msgArr.length; i++) {
			hand += (msgArr[i] + " ");
		}
		switch (msgArr[0]) {
		case "ī��Ʈ":

			System.out.println("ī��Ʈ??"+count);
			
			this.setCount(Integer.parseInt(msg.split(" ")[1].trim()));

			System.out.println("ī��Ʈ!!"+count);
			
			if (count == 2 && use[0] == 0) {
				jari1.append("�α���");
				use[0]++;
			}
			if (count == 3 && use[1] == 0) {
				use[1]++;
				jari2.setText("�α��� ");
				

			}
			if (count == 4) {
				jari3.setText("�α��� ");
				jari3.setBackground(Color.blue);

			}
			if(count==5) {
				jari4.setText("�α���");
				jari4.setBackground(Color.blue);
			}
			if(count==6) {
				jari5.setText("�α���");
				jari5.setBackground(Color.blue);
				
			}
			if(count==7) {
				jari6.setText("�α��� ");
				jari6.setBackground(Color.blue);
			}
		break;
		case "1���ڸ�":
			jari1.append("1���ڸ�");
			jari1.setBackground(Color.blue);
			break;
		case "2���ڸ�":	
			
			System.out.println(hand);
			jari2.append("2���ڸ�");
			jari2.setBackground(Color.blue);
			
			break;
		case "3���ڸ�":
			System.out.println("?");
			jari3.append("3���ڸ�");
			break;
		case "4���ڸ�":
			System.out.println("?");
			jari4.append("4���ڸ�");
			break;
		case "5���ڸ�":
			jari5.append("5���ڸ�");
			break;
		case "6���ڸ�":
			jari6.append("6���ڸ�");
			break;
		}
		
		

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

	public void disconnect() {
		try {
			in.close();
			out.close();
			serversocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				out.println("1���ڸ����� �����Ͽ����ϴ�");
				addMessage(in.readLine() + "\n");

			}
		} catch (IOException e) {
			disconnect();
		}
	}

	public static void main(String[] args) {
		clientserver mf = new clientserver("pc�� ����");
		mf.pack();
		mf.setSize(1000, 500);
		mf.setVisible(true);

		mf.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		mf.connect("localhost", 9997);

		Thread thread = new Thread(mf);
		thread.start();
	}

	class InputListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String input = jari1.getText();
			jari1.setText("");

			try {
				out.println(input);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
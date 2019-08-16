package com.pc.main;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import com.pc.biz.PcBiz;
import com.pc.dao.PcDao;
import com.pc.dto.PcDto;

public class NetworkThread extends Thread {

	private Main server;
	private Socket socket;

	private String userName;
	private PrintWriter out;
	private BufferedReader in;
	private int count;

	public String getUserName() {
		return userName;
	}

	public NetworkThread(Main server, Socket socket, int count) {
		this.server = server;
		this.socket = socket;

		this.count = count;
	}

	public void sendMessage(String msg) throws IOException {
		if (out != null) {
			out.println(msg);
		}
	}

	public void run() {
		System.out.println("�մ��� " + socket + "���� �����߽��ϴ�.");
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				if (inputLine.contains("�α���")) {
					System.out.println("ī��Ʈ1 : " + count);
					//count = count + 1;
					if (count == 7) {
						out.println("�ڸ��� ��á���ϴ�.");
					} else {
						String[] msagg = inputLine.split(" ");
						String loginId = msagg[1];
						String loginPw = msagg[2];
						PcBiz biz = new PcBiz();
						PcDto dto = biz.login(loginId, loginPw);
						System.out.println("ī��Ʈ2 : " + count);
						if (dto.getId() != null) {
							server.seat(count, loginId);
							System.out.println("Count: " + count);
							out.println("�α��μ���");
						} else {
							out.println("�α��ν���");
						}
					}
				} else if (inputLine.contains("�α׾ƿ�")) {
					out.close();
					in.close();
					socket.close();
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {

			e.printStackTrace();
			server.removeClient(this);
			System.out.println(count + "���� �����̽��ϴ�.");
			System.out.println();
		}

	}

}

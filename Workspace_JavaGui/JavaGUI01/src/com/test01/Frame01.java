package com.test01;

import java.awt.Button;
import java.awt.Frame;

/*
	java.awt�� UTF-8 encoding ���� �� ��ó�� :
	��� �޴��� run -> run configuration -> Arguments tab -> vm arguments�� ���� ��� ����
	-Dfile.encoding=MS949
 */

/*
 * awt �ڵ� ����(��õ�� ����) :
 * 1. �ʵ忡 ��ü ����
 * 2. �����ڿ��� ��ü ����
 * 3. ������ ���̾ƿ� ����
 * 4. �гο� ��ü�� �ø���.
 * 5. �����ӿ� �г��� �ø���.
 * 6. �̺�Ʈ ����.
 */
public class Frame01 extends Frame {

	Button btn;
	
	public Frame01() {
		btn = new Button("push");
	}
	
	public void go() { //�����ӿ� �ְ�
		add(btn);
		
		setSize(500,500);
		setVisible(true); //������ ����
	}
	
	public static void main(String[] args) {
		Frame01 f = new Frame01();
		f.go();
	}
}

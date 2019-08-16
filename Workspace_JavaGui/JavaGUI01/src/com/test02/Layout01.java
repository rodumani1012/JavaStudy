package com.test02;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class Layout01 extends Frame {
	
	// GridBagConstraints Ŭ������ GridBagLayout Ŭ������ ����Ͽ� 
	// ��ġ�Ǵ� ������ҿ� ���� ���������� �����Ѵ�.
	public void makeButton(String name, GridBagLayout gridBag,
			GridBagConstraints constraints) {
		
		Button btn = new Button(name);

		// GridBagLayout�� �Ӽ� ����(component, �Ӽ�)
		gridBag.setConstraints(btn, constraints);

		// �ش� �Ӽ��� ������ �߰�����
		add(btn);
	}

	public void go() {

		// ���ڹ��� layout
		GridBagLayout gridBag = new GridBagLayout();
		// �Ӽ�(��������)
		GridBagConstraints constraints = new GridBagConstraints();
		// ������(this)���� ���̾ƿ� ����.
		setLayout(gridBag);

		// fill : component�� ũ�⸦ ä���ִ� ����. (NONE, HORIZONTAL, VERTICAL, BOTH..)
		// NONE : �ڱ� �ڽ� ��ŭ��.
		constraints.fill = GridBagConstraints.BOTH;

		// weightx : �� ĭ�� ���� component�� ���� �� ������ ����
		constraints.weightx = 1.0; // ������ 1�� �ְڴ�. 1 : 1 : 1
		makeButton("Btn01", gridBag, constraints);
		makeButton("Btn02", gridBag, constraints);
		makeButton("Btn03", gridBag, constraints);

		//gridwidth : row �Ӽ� (���� cell ����)
		//REMAINDER : ���� ���� ������ ��(�� ���ڶ��� ä��ڴ�.)
		constraints.gridwidth = GridBagConstraints.REMAINDER; 
		makeButton("Btn04", gridBag, constraints);

		constraints.weightx = 0.0; // ������ ���ְڴ�.
		makeButton("Btn05", gridBag, constraints);

		// RELATIVE : �ش� row�� ������ component ����
		//(���� ������Ʈ�� ������/�Ʒ���) ����ϰ��� �� ��
		// �� ���� �� �������� ���ڴ�.
		constraints.gridwidth = GridBagConstraints.RELATIVE;
		makeButton("Btn06", gridBag, constraints);

		constraints.gridwidth = GridBagConstraints.REMAINDER;
		makeButton("Btn07", gridBag, constraints);

		constraints.gridwidth = 2; // ���μ� ����
		constraints.gridheight = 2; // ���μ� ����
		constraints.weighty = 1.0;
		makeButton("Btn08", gridBag, constraints);

		constraints.weighty = 0.0;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.gridheight = 1;
		makeButton("Btn09", gridBag, constraints);
		makeButton("Btn10", gridBag, constraints);

		constraints.gridwidth = 2;
		makeButton("Btn11", gridBag, constraints);
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		makeButton("Btn12", gridBag, constraints);

		setSize(400, 180);
	}

	public static void main(String[] args) {
		Layout01 f = new Layout01();
		f.setVisible(true);
		f.go();
	}

}

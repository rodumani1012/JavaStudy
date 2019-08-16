package com.pc.admin;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.pc.dto.TimeDto;
import com.pc.gui.OverTime;
import com.pc.gui.TimeCal;

public class IdSearch_OverTime extends Frame{
	Panel p01;
	Label lbId;
	Button btnSearch, btnCancel;
	TextField txtId;

	public IdSearch_OverTime() {
		p01 = new Panel();
		lbId = new Label("���̵�");
		txtId = new TextField(30);	// id �޾Ƽ�
		btnSearch = new Button("�˻�");
		btnCancel = new Button("���");
	}
	
	public void go() {
		p01.setLayout(new GridLayout(2,2));
		p01.add(lbId);
		p01.add(txtId);
		p01.add(btnSearch);
		p01.add(btnCancel);
		
		SearchEvent actionEvents = new SearchEvent();
		
		btnSearch.addActionListener(actionEvents);
		btnCancel.addActionListener(actionEvents);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		add(p01);
		setSize(300,80);
		setVisible(true);
	}
	
	class SearchEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			OverTime overtime = new OverTime();
			TimeCal timecal = new TimeCal();
			Button btn = (Button)e.getSource();
			System.out.println(btn);
			if(btn.getLabel().equals("�˻�")) {
				overtime.setId(String.valueOf(txtId.getText()));
				timecal.setId(String.valueOf(txtId.getText()));
				TimeDto dto = new TimeDto();
				dto.setId(String.valueOf(txtId.getText()));
				overtime.go();
				// �Լ��� id �ֱ�
				System.out.println("Idsearch : "+dto.getId());
			}else if(btn.getLabel().equals("���")) {
				dispose();
			}
		}
	}
	
	public static void main(String[] args) {
		new IdSearch_OverTime().go();
	}
}

package com.pc.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.pc.biz.PcBiz;
import com.pc.dao.PcDao;
import com.pc.dto.PcDto;
import com.pc.gui.PcGui;


public class userinsert extends JFrame {

   // ȸ������ �� �ʵ� ����
   JPanel p;
   JLabel join_id, join_pw, join_pwc, join_ex, join_name, join_dob, join_tel, join_addr;
   JTextField tt_id, tt_name, tt_dob, tt_tel, tt_addr;
   JPasswordField tt_pw, tt_pwc;
   JButton chek, join_ok, no;
   String myid;
   char[] mypw;

   public userinsert() {

      setLayout(null);
      join_id = new JLabel("���̵�  ");
      join_pw = new JLabel("��й�ȣ  ");
      join_pwc = new JLabel("��й�ȣ  Ȯ��");
      join_ex = new JLabel("��(��,�ҹ�)��, ���ڸ� 10�� �̻�");
      join_name = new JLabel("�̸� ");
      join_dob = new JLabel("�������");
      join_tel = new JLabel("��ȭ��ȣ");
      join_addr = new JLabel("�ּ�");
      tt_id = new JTextField(20);
      tt_pw = new JPasswordField(20);
      tt_pwc = new JPasswordField(20);
      tt_name = new JTextField(20);
      tt_dob = new JTextField(20);
      tt_tel = new JTextField(20);
      tt_addr = new JTextField(40);
      chek = new JButton("�ߺ�üũ");
      join_ok = new JButton("���Կ�û");
      no = new JButton("���");
   }

   public void go() {

      // ȸ������ ��
      p = new JPanel();
      join_id.setBounds(10, 10, 80, 35);
      join_pw.setBounds(10, 54, 80, 35);
      join_ex.setBounds(310, 54, 250, 35);
      join_pwc.setBounds(10, 98, 100, 35);
      join_name.setBounds(18, 144, 80, 35);
      join_dob.setBounds(10, 188, 80, 35);
      join_tel.setBounds(10, 232, 80, 35);
      join_addr.setBounds(18, 282, 80, 35);
      tt_id.setBounds(100, 10, 200, 30);
      tt_pw.setBounds(100, 55, 200, 30);
      tt_pwc.setBounds(100, 100, 200, 30);
      tt_name.setBounds(100, 145, 200, 30);
      tt_dob.setBounds(100, 190, 200, 30);
      tt_tel.setBounds(100, 235, 200, 30);
      tt_addr.setBounds(100, 285, 200, 30);
      chek.setBounds(310, 10, 90, 30);
      join_ok.setBounds(100, 325, 90, 35);
      no.setBounds(208, 325, 90, 35);


      //event
      
      chek.addActionListener(new UserEvents());
      join_ok.addActionListener(new UserEvents());
      no.addActionListener(new UserEvents());
      // panel�� �ø���

      add(join_id);
      add(join_pw);
      add(join_ex);
      add(join_pwc);
      add(join_name);
      add(join_dob);
      add(join_tel);
      add(join_addr);
      add(tt_id);
      add(tt_pw);
      add(tt_pwc);
      add(tt_name);
      add(tt_dob);
      add(tt_tel);
      add(tt_addr);
      add(chek);
      add(join_ok);
      add(no);

      setSize(550, 450);
      setVisible(true);
   }

   public static void main(String[] args) {
      new userinsert().go();
   }

   class UserEvents extends WindowAdapter implements ActionListener {
      PcDto dto = new PcDto();
      PcBiz biz = new PcBiz();
      PcDao dao = new PcDao();
      
      
      @Override
      public void actionPerformed(ActionEvent e) {
         if (e.getActionCommand().trim().equals("�ߺ�üũ")) {
            PcBiz biz = new PcBiz();
            String id = tt_id.getText();

            if (biz.idchek(id).getId() == null) {
               JOptionPane.showMessageDialog(null, "����� ���� �� ���̵� �Դϴ�.");
               tt_pw.requestFocus();
            } else {
               JOptionPane.showMessageDialog(null, "�̹� ���� �� ���̵� �Դϴ�. �ٸ� ���̵� �Է� �� �ּ���.");
               tt_id.requestFocus();
            }

            // ���� �ϸ鼭 fromâ �ݱ�
         }
         if (e.getActionCommand().trim().equals("���Կ�û")) {
            String pw = String.copyValueOf(tt_pw.getPassword());
            String pwc = String.copyValueOf(tt_pwc.getPassword());
            dto.setId(tt_id.getText());
            dto.setPw(String.copyValueOf(tt_pw.getPassword()));
            dto.setName(tt_name.getText());
            dto.setDob(tt_dob.getText());
            dto.setTel(tt_tel.getText());
            dto.setAddr(tt_addr.getText());
            if (pw.length() >= 10) {

               if (pw.equals(pwc)) {
                  int res = biz.insert(dto);

                  if (res > 0) {
                     JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ� �Ǿ����ϴ�!");
                     dispose();
                     
                     
                  }
               } else {
                  JOptionPane.showMessageDialog(null, "�Է��Ͻ� ��й�ȣ�� ���� �ʽ��ϴ�.");
                  tt_pw.requestFocus();
               }
            } else {
               JOptionPane.showMessageDialog(null, "10�� �̻����� �־� �ּ���");
            }
         }

         if (e.getActionCommand().trim().equals("���")) {
            tt_id.setText("");
            tt_pw.setText("");
            tt_pwc.setText("");
            tt_name.setText("");
            tt_dob.setText("");
            tt_tel.setText("");
            tt_addr.setText("");
            dispose();
         }

      }

   }

}
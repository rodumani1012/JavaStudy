package com.pc.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.pc.biz.PcBiz;
import com.pc.dao.PcDao;
import com.pc.dto.PcDto;

public class userhome extends JFrame {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   // 1.�ʵ忡�� ����(����ȭ��)
   JLabel label1_id, label1_name, label1_start, label1_end, label1_middle, t1_id, t1_name, t1_mypw, t1_start, t1_end,
         t1_middle;

   JButton me, messages, close1;
   JPanel p1, p2;
   JDialog form1;
   String myid;
   // 1.�ʵ忡�� ����(ȸ������)
   JLabel label2_id, label2_pw, label2_pwc, label2_name, label2_dob,label2_ex, label2_addr, label2_tel, t2_id;
   JPasswordField t2_pw, t2_pwc;
   JTextField t2_name, t2_dob, t2_addr, t2_tel;
   JButton update, close2;
   DateFormat dateFormat = new SimpleDateFormat("HH:mm");
   Date date = new Date();
   String start = dateFormat.format(date);

   // 2.�⺻������
   public void setMyid(String myid) {
      this.myid = myid;
   }

   public userhome(String myid) {

      PcDto dto = new PcDto();
      PcBiz biz = new PcBiz();

      dto = biz.myselectOne(myid);

      p1 = new JPanel();
      p2 = new JPanel();
      label1_id = new JLabel("���̵�: ");

      t1_id = new JLabel(dto.getId());

      label1_name = new JLabel("��     �� : ");
      t1_name = new JLabel(dto.getName());

      label1_start = new JLabel("���۽ð� : ");
      t1_start = new JLabel(start);

      label1_end = new JLabel("���ð� : ");
      t1_end = new JLabel();

      label1_middle = new JLabel("�����ð� : ");
      t1_middle = new JLabel(getTitle());

      me = new JButton("����������");
      messages = new JButton("�޽���");
      close1 = new JButton("�������");

      form1 = new JDialog(this, "����������", true);
      label2_id = new JLabel("��  ��  ��");
      label2_pw = new JLabel("��й�ȣ");
      label2_ex = new JLabel("��(��,�ҹ�)��, ���ڸ� 10�� �̻�");
      label2_pwc = new JLabel("��й�ȣ Ȯ��");
      label2_name = new JLabel("��         ��");
      label2_dob = new JLabel("�������");
      label2_addr = new JLabel("��         ��");
      label2_tel = new JLabel("��ȭ��ȣ");
      t2_id = new JLabel(dto.getId());
      t2_pw = new JPasswordField(20);
      t2_pwc = new JPasswordField(20);
      t2_name = new JTextField(20);
      t2_dob = new JTextField(20);
      t2_addr = new JTextField(20);
      t2_tel = new JTextField(20);

      update = new JButton("��������");
      close2 = new JButton("���");

      /*
       * DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); Calendar
       * cal = Calendar.getInstance();
       * System.out.println(dateFormat.format(cal.getTime())); ����ð�(���۽ð�)
       */
   }

   public void go() {

      // 3. panel�� ������Ʈ�ø���
      // Login�� ����ȭ��
      label1_id.setBounds(70, 20, 100, 50);
      label1_name.setBounds(70, 30, 100, 100);
      label1_start.setBounds(70, 40, 100, 150);
      label1_end.setBounds(70, 50, 100, 200);
      label1_middle.setBounds(70, 60, 100, 250);
      t1_id.setBounds(140, 32, 150, 25);
      t1_name.setBounds(140, 67, 150, 25);
      t1_start.setBounds(140, 102, 150, 25);
      t1_end.setBounds(140, 137, 150, 25);
      t1_middle.setBounds(140, 172, 150, 25);
      me.setBounds(20, 210, 120, 25);
      messages.setBounds(150, 210, 100, 25);
      close1.setBounds(260, 210, 100, 25);

      // Login�� ȸ������ ���� ��
      label2_id.setBounds(50, 20, 100, 50);
      label2_pw.setBounds(50, 30, 100, 100);
      label2_ex.setBounds(300,30, 250, 100);
      label2_pwc.setBounds(50, 40, 100, 150);
      label2_name.setBounds(50, 50, 100, 200);
      label2_dob.setBounds(50, 60, 100, 250);
      label2_tel.setBounds(50, 70, 100, 300);
      label2_addr.setBounds(50, 80, 100, 350);
      t2_id.setBounds(140, 32, 150, 25);
      t2_pw.setBounds(140, 67, 150, 25);
      t2_pwc.setBounds(140, 102, 150, 25);
      t2_name.setBounds(140, 137, 150, 25);
      t2_dob.setBounds(140, 172, 150, 25);
      t2_tel.setBounds(140, 207, 150, 25);
      t2_addr.setBounds(140, 245, 150, 25);
      update.setBounds(50, 280, 100, 25);
      close2.setBounds(190, 280, 100, 25);

      // 4. frame�� panel�ø���
      setTitle("KhPc��");
      add(label1_id);
      add(label1_name);
      add(label1_start);
      add(label1_end);
      add(label1_middle);
      add(t1_id);
      add(t1_name);
      add(t1_start);
      add(t1_end);
      add(t1_middle);
      add(me);
      add(messages);
      add(close1);
      add(p1);

      form1.add(label2_id);
      form1.add(label2_pw);
      form1.add(label2_ex);
      form1.add(label2_pwc);
      form1.add(label2_name);
      form1.add(label2_dob);
      form1.add(label2_tel);
      form1.add(label2_addr);
      form1.add(t2_id);
      form1.add(t2_pw);
      form1.add(t2_pwc);
      form1.add(t2_name);
      form1.add(t2_dob);
      form1.add(t2_tel);
      form1.add(t2_addr);
      form1.add(update);
      form1.add(close2);
      add(p2);

      // event
      me.addActionListener(new PcEvents());

      form1.addWindowListener(new PcEvents());
      this.addWindowListener(new PcEvents());
      close2.addActionListener(new PcEvents());
      close1.addActionListener(new PcEvents());
      update.addActionListener(new PcEvents());
      // view

      // ��üȭ�� ���
      // setExtendedState(JFrame.MAXIMIZED_BOTH);
      // setUndecorated(true);

      setBounds(1522, 5, 1520, 5);
      setSize(400, 300);
      setVisible(true);
      form1.setBounds(1100, 5, 1100, 5);
      form1.setSize(550, 375);
      form1.setLayout(null);
   }

   class PcEvents extends WindowAdapter implements ActionListener {
      PcDto dto = new PcDto();
      PcBiz biz = new PcBiz();
      PcDao dao = new PcDao();

      @Override
      public void actionPerformed(ActionEvent e) {
         int result = 0;
         if (e.getActionCommand().trim().equals("����������")) {
            form1.setVisible(true);
         }
         if (e.getActionCommand().trim().equals("��������")) {
            String pw = String.copyValueOf(t2_pw.getPassword());
            String pwc = String.copyValueOf(t2_pwc.getPassword());
            dto.setId(t2_id.getText());
            dto.setPw(String.copyValueOf(t2_pw.getPassword()));
            dto.setName(t2_name.getText());
            dto.setDob(t2_dob.getText());
            dto.setTel(t2_tel.getText());
            dto.setAddr(t2_addr.getText());
            if (pw.length() > 10) {
               if (pw.equals(pwc)) {
                  int res = biz.update(dto);

                  if (res > 0) {
                     JOptionPane.showMessageDialog(null, "������ �Ϸ� �Ǿ����ϴ�.");
                     form1.dispose();
                  } 
               }else {
                  JOptionPane.showMessageDialog(null, "�Է��Ͻ� ��й�ȣ�� ���� �ʽ��ϴ�.");
                  t2_pw.requestFocus();
               }
            }else {
               JOptionPane.showMessageDialog(null, "10�� �̻����� �־� �ּ���");
            }
         }
         if (e.getActionCommand().trim().equals("���")) {
            t2_pw.setText("");
            t2_pw.setText("");
            t2_name.setText("");
            t2_dob.setText("");
            t2_tel.setText("");
            t2_addr.setText("");
            form1.dispose();
         }
         if (e.getActionCommand().trim().equals("�������")) {
            JOptionPane.showConfirmDialog(null, "����� ���� �Ͻðڽ��ϱ�?", "Confirm", JOptionPane.YES_NO_OPTION);
            // Yes or No �� �ƴ� X������ ���� ���
            if (result == JOptionPane.CLOSED_OPTION) {

               // Yes��ư ������ ���
            } else if (result == JOptionPane.YES_OPTION) {
               dispose();
               clientName pc = new clientName();
               pc.go();
               // ������ No��ư ������ ���
            } else {

            }
         }
      }

      @Override
      public void windowClosing(WindowEvent e) {
         if (e.getSource().getClass() == JDialog.class) {
            form1.setVisible(false);
         }
      }
   }

   public static void main(String[] args) {

      new clientName().go();

   }
}
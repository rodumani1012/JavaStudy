package main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.border.EtchedBorder;

public class PassWord extends JFrame {
   private static String password = "pass";

   JLabel pwtext;

   JPasswordField field = new JPasswordField(10);

   public PassWord() {

//        Ÿ��Ʋ�̸�
      super("������");
//      FlowLayout���
      setLayout(new FlowLayout());
//       Border�� ���� ����
      EtchedBorder eborder = new EtchedBorder();
//        ���̺� ����
      pwtext = new JLabel("�н����带 �Է��� �ּ���");
//        ���̺� ���� �����
      pwtext.setBorder(eborder);
//        ���̺� �߰�
      add(pwtext);

//      swing ����
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//      ��й�ȣ ��ġ ���� Ȯ��
      field.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            System.out.println("Field=" + field.getText());
            JPasswordField input = (JPasswordField) e.getSource();
            char[] passy = input.getPassword();
            String p = new String(passy);

            if (p.equals(password)) {
            	new Inventory();
               dispose();
            } else {
               JOptionPane.showMessageDialog(null, "��й�ȣ�� �ƴմϴ�");
//               dispose();
            }
         }
      });

//     ��й�ȣ â
      getContentPane().add(field);
      pack();
      setVisible(true);
      setSize(300, 102);
   }
}
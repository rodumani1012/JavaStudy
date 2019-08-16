package com.pc.admin;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.pc.dao.MemberDAO;
import com.pc.gui.Name_Search;

public class Condition_search0 extends JFrame implements ActionListener, MouseListener {

	private JFrame frame;
	private JRadioButton rb, rb1;
	private JPanel contentPane, contentPane1;
	public static JTextField textField, textField1;
	private ButtonGroup option;
	private JLabel lblNewLabel, lblNewLabel1;
	private Button name_search, Id_search;
	
	Vector v;
	Vector cols;
	DefaultTableModel model;
    JTable jTable;
    JScrollPane pane;
    JPanel pbtn;
    JButton btnInsert;
	
	
	public Condition_search0(){
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//
		MemberDAO dao = new MemberDAO();
		v = dao.getMemberList();
		cols = getColumn();
		model = new DefaultTableModel(v,cols);
		jTable = new JTable(model);
        pane = new JScrollPane(jTable);
        add(pane);
		

		rb = new JRadioButton("�̸����� �˻�");
		rb.setBounds(29, 38, 139, 27);
		contentPane.add(rb);

		rb1 = new JRadioButton("���̵�� �˻�");
		rb1.setBounds(194, 38, 139, 27);
		contentPane.add(rb1);

		option = new ButtonGroup();
		option.add(rb);
		option.add(rb1);
		

		rb.addActionListener(this);
		rb1.addActionListener(this);
		

		textField = new JTextField();
//		textField.setText("�̸��Է�â");
		textField.setBounds(73, 95, 116, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		textField1 = new JTextField();
//		textField1.setText("���̵��Է�â");
		textField1.setBounds(73, 95, 116, 24);
		contentPane.add(textField1);
		textField1.setColumns(10);
		textField1.setVisible(false);
		
		name_search = new Button("�̸��˻�");
		name_search.setBounds(199, 94, 75, 24);
		contentPane.add(name_search);
		name_search.setVisible(false);
		name_search.addActionListener(this);
		lblNewLabel = new JLabel("�˻� ������ �����ϼ���.");
		lblNewLabel.setBounds(14, 98, 200, 18);
		contentPane.add(lblNewLabel);

		Id_search = new Button("���̵�˻�"	);
		Id_search.setBounds(199, 94, 75, 24);
		contentPane.add(Id_search);
		Id_search.setVisible(false);
		Id_search.addActionListener(this);

		
		//
		jTable.addMouseListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
	}
	
	//JTable�� �÷�
    public Vector getColumn(){
        Vector col = new Vector();
        col.add("���̵�");
        col.add("��й�ȣ");
        col.add("�̸�");
        col.add("��ȭ");
        col.add("�ּ�");
        col.add("����");
       
        return col;
    }//getColumn

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rb) {
			System.out.println("�̸����� �˻� ����");

			textField1.setVisible(false);
			lblNewLabel.setVisible(false);
			Id_search.setVisible(false);
			//--------------------------
			
			textField.setVisible(true);
			lblNewLabel.setVisible(true);
			lblNewLabel.setBounds(14, 98, 62, 18);
			lblNewLabel.setText("�̸� : ");
			name_search.setVisible(true);
			
		} else if(e.getSource() == rb1){
			System.out.println("���̵�� �˻� ����");
			textField.setVisible(false);
			lblNewLabel.setVisible(false);
			name_search.setVisible(false);
			//--------------------------
			textField1.setVisible(true);
			lblNewLabel.setVisible(true);
			lblNewLabel.setBounds(14, 98, 62, 18);
			lblNewLabel.setText("���̵� : ");
			Id_search.setVisible(true);
		} else if(e.getSource() == name_search) {
			System.out.println("�˻� ");
			String inputname = textField.getText();
			Name_Search Nsearch = new Name_Search(inputname);
			Nsearch.setSize(500,500);
			Nsearch.setVisible(true);
			Nsearch.setTitle("�̸��˻�"); 
		} else if(e.getSource() == Id_search) {
			String inputid = textField1.getText();
			ID_Search Isearch = new ID_Search(inputid);
			Isearch.setSize(500,500);
			Isearch.setVisible(true);
			Isearch.setTitle("���̵� �˻�");
		}

		
	}
	

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Condition_search0 frame = new Condition_search0();
					frame.setVisible(true);
					frame.setTitle("���ǰ˻�");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//		int r = jTable.getSelectedRow();
//        String id = (String) jTable.getValueAt(r, 0);
//        //System.out.println("id="+id);
//        MemberProc mem = new MemberProc(id,new Member_List()); //���̵� ���ڷ� ����â ����
//        System.out.println(" x ");
	}

	@Override
	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//		int r = jTable.getSelectedRow();
//        String id = (String) jTable.getValueAt(r, 0);
//        //System.out.println("id="+id);
//        MemberProc mem = new MemberProc(id,new Member_List()); //���̵� ���ڷ� ����â ����
//        System.out.println(" x ");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		int r = jTable.getSelectedRow();
      String id = (String) jTable.getValueAt(r, 0);
      //System.out.println("id="+id);
      MemberProc mem = new MemberProc(id,new Member_List()); //���̵� ���ڷ� ����â ����
      System.out.println(" x ");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
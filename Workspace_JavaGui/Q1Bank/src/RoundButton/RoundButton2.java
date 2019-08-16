package RoundButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.dto.BankDto;

public class RoundButton2 extends JFrame {


	private JPanel contentPane;
	public JButton button_4;
	public JButton getButton_4() {
		return button_4;
	}

	public void setButton_4(JButton button_4) {
		this.button_4 = button_4;
	} 

	JButton logoutBtn;
	private JButton outputBtn;
	private JButton tradeInfoBtn;
	
	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoundButton2 frame = new RoundButton2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	//기본 생성자
	public RoundButton2() {

	}
	
	// dto받는  생성자
	public RoundButton2(BankDto logindto) {
		setBackground(new Color(0, 0, 255));
		setFont(new Font("HY헤드라인M", Font.PLAIN, 99));
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hicja\\Pictures\\a.PNG"));
		setTitle("1조 은행");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setToolTipText("");
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton tradeBtn = new JButton("계좌이체");
		tradeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TransferGUI transfergui = new TransferGUI(logindto);
				transfergui.setVisible(true);
				setVisible(false);
			}
		});
		tradeBtn.setForeground(new Color(255, 255, 255));
		tradeBtn.setBackground(new Color(51, 204, 204));
		tradeBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		tradeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tradeBtn.setBounds(50, 250, 163, 40);
		panel.add(tradeBtn);
		
		JButton inputBtn = new JButton("입   금");
		inputBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DealDeposit dealdeposit = new DealDeposit(logindto);
	            dealdeposit.setVisible(true);
	            setVisible(false);
			}
		});
		inputBtn.setForeground(new Color(255, 255, 255));
		inputBtn.setBackground(new Color(51, 204, 204));
		inputBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		inputBtn.setBounds(50, 50, 163, 40);
		panel.add(inputBtn);
		
		logoutBtn = new JButton("로그아웃");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(logoutBtn.getText() == "로그아웃") {
					RoundButton main = new RoundButton();
					main.setVisible(true);
					dispose();
				}
			}
		});
		logoutBtn.setForeground(Color.WHITE);
		logoutBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		logoutBtn.setBackground(new Color(51, 204, 204));
		logoutBtn.setBounds(349, 250, 163, 40);
		panel.add(logoutBtn);
		
		outputBtn = new JButton("출   금");
		outputBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DealWithdraw dealwithdraw = new DealWithdraw(logindto);
				dealwithdraw.setVisible(true);
				setVisible(false);
			}
		});
		outputBtn.setForeground(Color.WHITE);
		outputBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		outputBtn.setBackground(new Color(51, 204, 204));
		outputBtn.setBounds(50, 150, 163, 40);
		panel.add(outputBtn);
		
		tradeInfoBtn = new JButton("계좌조회");
		tradeInfoBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LookAccount	lookAccount = new LookAccount(logindto);
				lookAccount.setVisible(true);
				setVisible(false);
				
			}
		});
		tradeInfoBtn.setForeground(Color.WHITE);
		tradeInfoBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		tradeInfoBtn.setBackground(new Color(51, 204, 204));
		tradeInfoBtn.setBounds(349, 150, 163, 40);
		panel.add(tradeInfoBtn);
	}

}
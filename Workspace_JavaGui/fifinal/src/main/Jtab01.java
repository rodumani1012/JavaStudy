package main;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
public class Jtab01 extends JFrame{
 
    /*�ʿ��� ������Ʈ �غ�*/
   
    JTabbedPane t = new JTabbedPane();  //JTabbedPane����
   
    JPanel p1 = new JPanel(); //JPanel ����
   
    JButton btn1 = new JButton("�� ����1");
    JButton btn2 = new JButton("�� ����2");
    JButton btn3 = new JButton("�� ����3");
    JTextField txt_1 = new JTextField("�⺻��",25);
   
         
    public Jtab01() {  //������
       
        super("TabTitleTextPosition"); //������ Ÿ��Ʋ ���� ����
       
        /*try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //���� �ڹ� ������ ������� ���µ� �̰��� ����� ��� �ڽ��� �������� ������� ����ϰ� �ȴ�.
        }catch(Exception e) {
            e.printStackTrace();
        }*/
       
        p1.add(btn1); //�гο� ��ư�߰�
        p1.add(btn2); //�гο� ��ư�߰�
        p1.add(btn3); //�гο� ��ư�߰�
        p1.add(txt_1); //�гο� �ؽ�Ʈ�ʵ��߰�
               
        t.add("��� ����", new JTextArea()); //JTabbedPane�� ���߰�
        //Component javax.swing.JTabbedPane.add(String title, Component component)
       
        t.add("���� ����", p1);
        t.add("ȸ����������", new JTextArea());
        t.add("About",new JTextArea());
       
        add(t);
     
        //frame.pack();
        setSize(450, 350);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
    }//������ ��
 
    public static void main(String[] args) {
        new Jtab01();
       
    }//���θ޼ҵ� ��
 
}//Ŭ���� ��
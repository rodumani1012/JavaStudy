package com.pc.dao;

//�̸� ��Ģ : ���̺��DAO , ���̺��DTO
//CRUD : Create;insert , Read;Select, Update, delete
 
import java.sql.*;
import java.util.Vector;
 
import javax.swing.table.DefaultTableModel;

import com.pc.admin.Member_List;
import com.pc.dto.MemberDTO;
 
//DB ó��
public class MemberDAO {
 
    private static final String DRIVER
        = "oracle.jdbc.driver.OracleDriver";
    private static final String URL
        = "jdbc:oracle:thin:@localhost:1521:xe";
   
    private static final String USER = "kh"; //DB ID
    private static final String PASS = "kh"; //DB �н�����
    Member_List mList;
   
    public MemberDAO() {
   
    }
   
    public MemberDAO(Member_List mList){
        this.mList = mList;
        System.out.println("DAO=>"+mList);
    }
   
    /**DB���� �޼ҵ�*/
    public Connection getConn(){
        Connection con = null;
       
        try {
            Class.forName(DRIVER); //1. ����̹� �ε�
            con = DriverManager.getConnection(URL,USER,PASS); //2. ����̹� ����
           
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return con;
    }
   
   
    /**�ѻ���� ȸ�� ������ ��� �޼ҵ�*/
    public MemberDTO getMemberDTO(String id){
       
        MemberDTO dto = new MemberDTO();
       
        Connection con = null;       //����
        PreparedStatement ps = null; //���
        ResultSet rs = null;         //���
       
        try {
           
            con = getConn();
            String sql = "select * from KHPC where id=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
           
            rs = ps.executeQuery();
           
            if(rs.next()){
                dto.setId(rs.getString("ID"));
                dto.setPwd(rs.getString("PW"));
                dto.setName(rs.getString("NAME"));
                dto.setTel(rs.getString("TEL"));
                dto.setAddr(rs.getString("ADDR"));
                dto.setBirth(rs.getString("DOB"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }      
       
        return dto;    
    }
   
    /**�������Ʈ ���*/
    public Vector getMemberList(){
       
        Vector data = new Vector();  //Jtable�� ���� ���� �ִ� ��� 1. 2�����迭   2. Vector �� vector�߰�
       
           
        Connection con = null;       //����
        PreparedStatement ps = null; //���
        ResultSet rs = null;         //���
       
        try{
           
            con = getConn();
            String sql = "select * from KHPC order by name asc";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           
            while(rs.next()){
                String id = rs.getString("ID");
                String pwd = rs.getString("PW");
                String name = rs.getString("NAME");
                String tel = rs.getString("TEL");
                String addr = rs.getString("ADDR");
                String birth = rs.getString("DOB");
               
                Vector row = new Vector();
                row.add(id);
                row.add(pwd);
                row.add(name);
                row.add(tel);
                row.add(addr);
                row.add(birth);
               
                data.add(row);             
            }//while
        }catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }//getMemberList()
   
 
 
    /**ȸ�� ���*/
    public boolean insertMember(MemberDTO dto){
       
        boolean ok = false;
       
        Connection con = null;       //����
        PreparedStatement ps = null; //���
       
        try{
           
            con = getConn();
            String sql = " INSERT INTO KHPC( " +
                        " ID,PW,NAME,TEL,ADDR,DOB " +
                        " VALUES(?,?,?,?,?,?) ";
           
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getPwd());
            ps.setString(3, dto.getName());
            ps.setString(4, dto.getTel());
            ps.setString(5, dto.getAddr());
            ps.setString(6, dto.getBirth());          
            int r = ps.executeUpdate(); //���� -> ����
           
            if(r>0){
                System.out.println("���� ����");   
                ok=true;
            }else{
                System.out.println("���� ����");
            }
           
        }catch(Exception e){
            e.printStackTrace();
        }
       
        return ok;
    }//insertMmeber
   
   
    /**ȸ������ ����*/
    public boolean updateMember(MemberDTO vMem){
        System.out.println("dto="+vMem.toString());
        boolean ok = false;
        Connection con = null;
        PreparedStatement ps = null;
        try{
           
            con = getConn();           
            String sql = "update KHPC set PW=?, NAME=?, TEL=?, ADDR=?, DOB=? where id=? ";
           
            ps = con.prepareStatement(sql);
           
            ps.setString(1, vMem.getPwd());
            ps.setString(2, vMem.getName());
            ps.setString(3, vMem.getTel());
            ps.setString(4, vMem.getAddr());
            ps.setString(5, vMem.getBirth());
            ps.setString(6, vMem.getId());
            //ps.setString(10, vMem.getPwd());
           
            int r = ps.executeUpdate(); //���� -> ����
            // 1~n: ���� , 0 : ����
           
            if(r>0) ok = true; //������ �����Ǹ� ok���� true�� ����
           
        }catch(Exception e){
            e.printStackTrace();
        }
       
        return ok;
    }
   
    /**ȸ������ ���� :
     *tip: �ǹ������� ȸ�������� Delete ���� �ʰ� Ż�𿩺θ� üũ�Ѵ�.*/
    public boolean deleteMember(String id, String pwd){
       
        boolean ok =false ;
        Connection con =null;
        PreparedStatement ps =null;
       
        try {
            con = getConn();
            String sql = "delete from tb_member where id=? and pwd=?";
           
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, pwd);
            int r = ps.executeUpdate(); // ���� -> ����
           
            if (r>0) ok=true; //������;
           
        } catch (Exception e) {
            System.out.println(e + "-> �����߻�");
        }      
        return ok;
    }
   
   
    /**DB������ �ٽ� �ҷ�����*/   
    public void userSelectAll(DefaultTableModel model) {
       
       
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        try {
            con = getConn();
            String sql = "select * from tb_member order by name asc";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           
            // DefaultTableModel�� �ִ� ������ �����
            for (int i = 0; i < model.getRowCount();) {
                model.removeRow(0);
            }
 
            while (rs.next()) {
                Object data[] = { rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                       rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)};
 
                model.addRow(data);                
            }
 
        } catch (SQLException e) {
            System.out.println(e + "=> userSelectAll fail");
        } finally{
           
            if(rs!=null)
                try {
                    rs.close();
                } catch (SQLException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }
            if(ps!=null)
                try {
                    ps.close();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            if(con!=null)
                try {
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }
}

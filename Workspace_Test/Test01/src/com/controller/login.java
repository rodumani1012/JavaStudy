package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. ���۰��� �ѱ��� ���� ��� ���ڵ�ó����
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		  
		//2. ���۰� ������ User ��ü�� �����ϱ�
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String username = request.getParameter("username");
		
		User user = new User();
		user.setUserId(userId);
		user.setUserPwd(userPwd);
		user.setUsername(username);

		//3. ����Ͻ� ���� ó���ϴ� Ŭ������ �ش� �޼ҵ带 �����ϰ�, ó�� ����� ����
		user = dao.loginCheck(user);

		//4. ���� ����� ������ ����/���п� ���� ��������(����)�� �����ؼ� ������
		if (user.getUserId != null) {
			//�α��� ������ �ش� Ŭ���̾�Ʈ�� ���� ���� ��ü�� ������
			//���� ��ü�� Service �� ���� ���ϵ� ����� User ��ü�� ������
			request.getSession().setAttribute("user", user);
			response.sendRedirect("login.html");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script> "
					+ "alert('�α��� ����'); "
					+ "location.href='login.html'; "
					+ "</script>");
		}
		
	}

}

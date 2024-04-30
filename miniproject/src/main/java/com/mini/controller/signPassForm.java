package com.mini.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 회원 비밀번호
@WebServlet("/signPassForm")
public class signPassForm extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String nick= (String)session.getAttribute("nick");
		String id= (String)session.getAttribute("id");
		String pass= (String)session.getAttribute("pass");
		
		System.out.println("여기는 패스 폼가는길이 오바"+pass);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/Fhome/signPassForm.jsp");
		rd.forward(req, resp);
		
	}
}

package com.mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mini.dao.LogDao;
import com.mini.project.Member;

@WebServlet("/signProcess")
public class SignUpProController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String nick = req.getParameter("nick");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		System.out.println(pass);
		Member m  =new Member();
		m.setUserId(id);
		m.setPass(pass);
		m.setNickName(nick);
		m.setmPhone(phone);
		m.seteMail(email);
		
		LogDao Ldao = new LogDao();
		Ldao.insertMember(m);
		
		resp.sendRedirect("imgList");
	}
}

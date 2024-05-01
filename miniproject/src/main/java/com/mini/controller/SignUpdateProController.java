package com.mini.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mini.dao.LogDao;
import com.mini.project.Member;

@WebServlet("/signUpdateProcess")
public class SignUpdateProController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		String Sid= (String)session.getAttribute("id");
		String pass = req.getParameter("signpass");
		String nick = req.getParameter("nick");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		Member m  =new Member();
		m.setUserId(Sid);
		m.setPass(pass);
		m.setNickName(nick);
		m.setmPhone(phone);
		m.seteMail(email);
		
		LogDao Ldao = new LogDao();
		Ldao.updateMember(m);
		
		
		resp.sendRedirect("imgList");
	}
}

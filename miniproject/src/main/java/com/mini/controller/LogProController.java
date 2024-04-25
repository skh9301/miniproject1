package com.mini.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mini.dao.LogDao;
import com.mini.project.Member;

@WebServlet("/logProcess")
public class LogProController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String nick = req.getParameter("nick");
		Member m  =new Member();
		m.setUserId(id);
		m.setPass(pass);
		m.setNickName(nick);
		
		if(id==null || id.equals("")||pass==null||pass.equals("") ) {
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("alert('아이디와 패스워드가 입력이 되지 않앗습니다.')");
			out.println("history.back()");
			out.println("</script>");
			
		}
		
		LogDao Ldao = new LogDao();
		Member member =Ldao.getMember(id,pass);
		
		req.setAttribute("member", member);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/Fhome/ListForm.jsp");
		rd.forward(req,resp);
	}
}


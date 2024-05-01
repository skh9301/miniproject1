package com.mini.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 회원 비밀번호
@WebServlet("/signUpdateForm")
public class signUpdateForm extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		
		HttpSession session = req.getSession();
		String Snick= (String)session.getAttribute("nick");
		String Sid= (String)session.getAttribute("id");
		String Spass= (String)session.getAttribute("pass");
		String pass = req.getParameter("Signpass");
		
		boolean passCheck = pass.equals(Spass);
		
		if(!passCheck) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다!')");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return;
		}
		
		
		req.setAttribute("nick", Snick);
		req.setAttribute("id", Sid);
		req.setAttribute("pass", pass);
		
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/Fhome/signUpdate.jsp");
		rd.forward(req, resp);
		
	}
}

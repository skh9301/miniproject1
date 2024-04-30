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
		
		if(passCheck==false) {
			System.out.println("여기는 회원수정폼으로가는 블린값이다"+passCheck);
			resp.setContentType("text/html; charset=utf-8;");
			PrintWriter out=resp.getWriter();
			out.println("<script>");
			out.print("alert('비밀번호가 일치하지 않습니다.')");
			out.print("history.back();");
			out.print("</script>");
			
		}
		
		req.setAttribute("nick", Snick);
		req.setAttribute("id", Sid);
		req.setAttribute("pass", pass);
		
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/Fhome/signUpdate.jsp");
		rd.forward(req, resp);
		
	}
}

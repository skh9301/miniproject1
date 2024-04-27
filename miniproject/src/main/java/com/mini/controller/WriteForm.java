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

import com.mini.dao.LogDao;

@WebServlet("/writeForm")
public class WriteForm extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LogDao Ldao =new LogDao();
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");

		if(id==null||id.equals("")) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("alert('로그인을 해주세요')");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return;
		}
		
		session.setAttribute("id",id);
		 session.setAttribute("pass",id);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/Fhome/ListWrite.jsp");
		rd.forward(req, resp);
	}
}

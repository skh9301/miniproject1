package com.mini.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mini.dao.ListDao;

@WebServlet("/updateForm")
public class updateForm extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		ListDao dao = new ListDao();
		String userId =req.getParameter("userId");
		String sNo =req.getParameter("no");
		int no = Integer.valueOf(sNo);
		
		//지금 로그인이 되어있는지
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
		
		//지금 로그인 된 아이디와 현 게시판의 아이디가 같은지
		if(!(id.equals(userId))) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("alert('아이디가 같지않습니다.')");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return;
		}
	
		
		ArrayList content = dao.getList(no);
		req.setAttribute("member", content.get(0));
		req.setAttribute("content", content.get(1));
		session.setAttribute("id",id);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/Fhome/ListUpdate.jsp");
		rd.forward(req, resp);
	}
}

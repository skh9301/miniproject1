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
		String pageNum =req.getParameter("pageNum");
		//검색 타입
		String type =req.getParameter("type");
		String keyword =req.getParameter("keyword");
		
		
		//검색 판별
				boolean isSearch = type==null || type.equals("")||keyword==null||keyword.equals("") ? false : true;
				
				//공유타입 채크박스 클릭했을때 
				String shareTypeCheck =req.getParameter("shareType");
				
				
				//공유 판별
				String shareType = shareTypeCheck==null || shareTypeCheck.equals("") ? "":"Y";
				
				boolean isShare =  shareTypeCheck==null || shareTypeCheck.equals("") ? false : true;
		  		
		
		LogDao Ldao =new LogDao();
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		String pass = (String)session.getAttribute("pass");

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
		System.out.println(pageNum);
		session.setAttribute("id",id);
		 session.setAttribute("pass",pass);
		 session.setAttribute("pageNum",pageNum);
		 
		 if (isSearch&&!isShare ) {
			 req.setAttribute("type", type);
			 req.setAttribute("keyword", keyword);
			//검색 x 공유 o
		}else if (!isSearch&&isShare ) {
			req.setAttribute("shareType", shareType);
			//검색o 공유o
		}else if (isSearch&&isShare ) {
			req.setAttribute("type", type);
			req.setAttribute("keyword", keyword);
			req.setAttribute("shareType", shareType);
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/Fhome/ListWrite.jsp");
		rd.forward(req, resp);
	}
}

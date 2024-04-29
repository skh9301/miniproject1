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

import com.mini.dao.ListDao;
import com.mini.project.Content;

@WebServlet("/deleteProcess")
public class DeleteController extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		String keyword = req.getParameter("keyword");
		
		
		boolean isSearch = type ==null || type.equals("") || keyword ==null || keyword.equals("") ? false : true;
		
		//공유타입 채크박스 클릭했을때 
				String shareTypeCheck =req.getParameter("shareType");
				
				
				//공유 판별
				String shareType = shareTypeCheck==null || shareTypeCheck.equals("") ? "":"Y";
				
				boolean isShare =  shareTypeCheck==null || shareTypeCheck.equals("") ? false : true;
		
				
		
		ListDao dao = new ListDao();
		String sNo =req.getParameter("no");
		String pageNum =req.getParameter("pageNum");
		int no = Integer.valueOf(sNo);
		dao.deleteContent(no);
		
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
		
		resp.sendRedirect("imgList?pageNum="+pageNum);
	}
}

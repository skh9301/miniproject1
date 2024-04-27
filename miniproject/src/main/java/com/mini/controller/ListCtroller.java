package com.mini.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.mini.dao.ListDao;
import com.mini.dao.LogDao;
import com.mini.project.Content;
import com.mini.project.Member;

@WebServlet("/imgList")
public class ListCtroller extends HttpServlet {
	
	// 한페이지에 기시글 10개 출력
		private static final int PAGE_SIZE =10;
		
		// 페이지 네이션의 크기 - 10씩
		private static final int PAGE_GROUP =10;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pageNum =req.getParameter("pageNum");
		
		if(pageNum==null) {
			pageNum="1";
		}
		
		/*
		 * //현재 페이지 int currentPage = Integer.parseInt(pageNum);
		 * 
		 * int startRow = currentPage
		 */
		ListDao Ldao = new ListDao();
		ArrayList<Content> cList= Ldao.getList();
		System.out.println(cList.get(13).getConFile());
		
		HttpSession session = req.getSession();
		String nick= (String)session.getAttribute("nick");
		String id= (String)session.getAttribute("id");
		req.setAttribute("nick", nick);
		req.setAttribute("id", id);
		req.setAttribute("cList", cList);
			
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/Fhome/ListForm.jsp");
		rd.forward(req,resp);
	}
}

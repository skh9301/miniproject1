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
		ListDao dao = new ListDao();
		String sNo =req.getParameter("no");
		String pageNum =req.getParameter("pageNum");
		int no = Integer.valueOf(sNo);
		dao.deleteContent(no);
		
		
		
		resp.sendRedirect("imgList?pageNum="+pageNum);
	}
}

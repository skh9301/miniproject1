package com.mini.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mini.dao.ListDao;
import com.mini.project.Content;

@WebServlet("/ListDetail")
public class DetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sNo =req.getParameter("no");
		int no = Integer.valueOf(sNo);
		ListDao dao = new ListDao();
		Content content = dao.getList(no);
		
		req.setAttribute("content", content);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/Fhome/ListDetail.jsp");
		rd.forward(req,resp);
		
	}
}

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

@WebServlet("/imgList")
public class ListCtroller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ListDao dao = new ListDao();
		ArrayList<Content> cList= dao.getList();
		
		req.setAttribute("cList", cList);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/Fhome/ListForm.jsp");
		rd.forward(req,resp);
	}
}

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

@WebServlet("/logoutPro")
public class LogOutController extends HttpServlet {
	

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		HttpSession session = req.getSession();
		session.invalidate();
		
			
			resp.sendRedirect("imgList");
	}
}

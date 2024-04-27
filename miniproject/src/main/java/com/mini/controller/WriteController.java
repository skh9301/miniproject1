package com.mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mini.dao.ListDao;
import com.mini.dao.LogDao;
import com.mini.project.Content;
import com.mini.project.Member;

@WebServlet("/writeProcess")
public class WriteController extends HttpServlet{
	
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	resp.setCharacterEncoding("utf-8");
	
	HttpSession session = req.getSession();
	
	String title = req.getParameter("Wtitle");
	String context = req.getParameter("Wcontext");
	String conFile = req.getParameter("WconFile");
	String writer = (String)session.getAttribute("id");
	String conShareCheck=req.getParameter("WconShare");
	
	String conShare = conShareCheck ==null ? "N" : "Y";
	System.out.println(writer);
	
	Content con= new Content();
	con.setConTitle(title);
	con.setConText(context);
	con.setConShare(conShare);
	con.setConFile(conFile);
	con.setUserId(writer);
	System.out.println(title);
	ListDao Ldao = new ListDao();
	Ldao.insertContent(con);
	
	resp.sendRedirect("imgList");
	}	
	
	
}

package com.mini.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mini.dao.ListDao;
import com.mini.project.Content;

@WebServlet("/ListDetail")
public class DetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		String keyword = req.getParameter("keyword");
		String isShare = req.getParameter("isShare");
		boolean searchOption = type ==null || type.equals("") || keyword ==null || keyword.equals("") ? false : true;
		
		
		
		
		String pageNum= req.getParameter("pageNum");
		String sNo =req.getParameter("no");
		int no = Integer.valueOf(sNo);
		ListDao dao = new ListDao();
		ArrayList content = dao.getList(no);
		Content con = (Content) content.get(1);
		String userId = con.getUserId();
		
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		// 로그인이 됬을때 세션에 저장된 아이디와 작성글 의 작성자와 일치하는지 확인
		boolean islogIn=false;
		if(id==null) {
			islogIn=false;
		}
		if(userId.equals(id)) {
			islogIn=true;
		}
		
		
		req.setAttribute("member", content.get(0));
		req.setAttribute("content", content.get(1));
		req.setAttribute("islogIn", islogIn);
		req.setAttribute("pageNum", pageNum);
		if(searchOption) {
			req.setAttribute("type", type);
			req.setAttribute("keyword", keyword);
		}
		req.setAttribute("isShare", isShare);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/Fhome/ListDetail.jsp");
		rd.forward(req,resp);
		
	}
}

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
		
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			
			doGet(request,response);
		}
		
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
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
  		
		//현재 페이지
		String pageNum =req.getParameter("pageNum");
		
		if(pageNum==null || pageNum.equals("")) {
			pageNum="1";
		}
		
		//현재 페이지 
		int currentPage = Integer.parseInt(pageNum);
		
		
		// 페이징 처리 startRow ~ endRow까지 출력 ( rownum 범위값)
		int startRow = currentPage*PAGE_SIZE-(PAGE_SIZE-1);
		int endRow = startRow +PAGE_SIZE-1;
		
		 
		//전체 게시글 수
		ArrayList<Content> cList =null;
		ListDao Ldao = new ListDao();
	
		int listCount =0;
		
		// 검색x 공유x
		if(!isSearch&&!isShare) {
			listCount = Ldao.getCount();
			cList= Ldao.getList( startRow,endRow);
			// 검색 o 공유 x 
		}else if (isSearch&&!isShare ) {
			listCount = Ldao.getCount(type,keyword);
			cList= Ldao.getList(type,keyword,startRow,endRow);
			//검색 x 공유 o
		}else if (!isSearch&&isShare ) {
			listCount = Ldao.getCount(type,keyword);
			cList= Ldao.getList(shareType,startRow,endRow);
			
			System.out.println(shareType);
			System.out.println("검색 x 공유 o");
			//검색o 공유o
		}else if (isSearch&&isShare ) {
			listCount = Ldao.getCount(type,keyword);
			cList= Ldao.getList(type,keyword,shareType,startRow,endRow);
		}
		//소수점 처리하기 위한 3항연산자  10개의 게시물당 1페이지 적어도 1페이지를 가지게 함
				int pageCount = listCount/PAGE_SIZE+(listCount/PAGE_SIZE== 0?0:1);
				
				//페이지 그룹 1~ 10까지 보이게
				int startPage = currentPage/ PAGE_GROUP*PAGE_GROUP +1
						-(currentPage%PAGE_GROUP == 0 ? PAGE_GROUP :0);
				int endPage= startPage+PAGE_GROUP -1;
				
				
				//만약 끝페이지가 더클경우 끝페이지는 현만들어진 페이지까지출력
				if(endPage > pageCount) {
					endPage = pageCount;
				}
		
		HttpSession session = req.getSession();
		String nick= (String)session.getAttribute("nick");
		String id= (String)session.getAttribute("id");
		req.setAttribute("nick", nick);
		req.setAttribute("id", id);
		req.setAttribute("cList", cList);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("pageGroup", PAGE_GROUP);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("isSearch", isSearch);
		req.setAttribute("isShare", isShare);
		
			// 검색 o 공유 x 
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
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/Fhome/ListForm.jsp");
			rd.forward(req,resp);
		}
}


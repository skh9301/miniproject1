package com.mini.controller;

import java.io.File;
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
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/updateProcess")
public class UpdateController extends HttpServlet{
	
	private static String uploadDir;
	private static File parentFile;
	
	@Override
	public void init() {
		// web.xml에 지정한 웹 어플리케이션 초기화 파라미터를 읽는다.
		uploadDir = getServletContext().getInitParameter("uploadDir");
		
		/* 웹 어플리케이션 초기화 파라미터에서 읽어온 파일이 저장될 폴더의 
		 * 로컬 경로를 구하여 그 경로와 파일명으로 File 객체를 생성한다.
		 **/
		String realPath = getServletContext().getRealPath(uploadDir);		
		parentFile = new File(realPath);
		
		/* 파일 객체에 지정한 위치에 디렉토리가 존재하지 않거나 
		 * 파일 객체가 디렉토리가 아니라면 디렉토리를 생성한다.
		 **/
		if(! (parentFile.exists() && parentFile.isDirectory())) {
			parentFile.mkdir();
		}
		System.out.println("init - " + parentFile);		
	}
	
	
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	String realPath =req.getServletContext().getRealPath(uploadDir);
	
	int maxFileSize =100* 1024 * 1024;
	
	String encoding = "UTF-8";
	
	HttpSession session = req.getSession();
	
	
	
	
	
	
	
	
	
	String conFile = req.getParameter("WconFile");
	boolean isFile = conFile ==null || conFile.equals("") ? false : true;
	
	String conShareCheck = null, pageNum=null,title = null, sNo=null,context = null, writer=null ,fileName=null;
	String type=null ,keyword=null,shareTypeCheck=null ;
	int no=0;
	
	
	
	
	
	
	//파일이 있을 경우
	if(!isFile) {
	MultipartRequest multi = new MultipartRequest(req,realPath,maxFileSize, 
						encoding,new DefaultFileRenamePolicy());
	
	
	 type = multi.getParameter("type");
		keyword = multi.getParameter("keyword");
		shareTypeCheck =multi.getParameter("shareType");
	pageNum = multi.getParameter("pageNum");
	title = multi.getParameter("Utitle");
	context = multi.getParameter("Ucontext");
	writer = (String)session.getAttribute("id");
	conShareCheck=multi.getParameter("UconShare");
	fileName = multi.getFilesystemName("UconFile");
	sNo = multi.getParameter("no");
	no = Integer.parseInt(sNo);
	
	}
	
	
	//// 파일이 없을경우
	if(isFile) {
	req.setCharacterEncoding("UTF-8");
	resp.setCharacterEncoding("utf-8");
	
	 type = req.getParameter("type");
		keyword = req.getParameter("keyword");
		shareTypeCheck =req.getParameter("shareType");
	pageNum = req.getParameter("pageNum");
	title = req.getParameter("Utitle");
	context = req.getParameter("Ucontext");
	writer = (String)session.getAttribute("id");
	conShareCheck=req.getParameter("UconShare");
	sNo = req.getParameter("no");
	no = Integer.parseInt(sNo);
	}
	String conShare = conShareCheck ==null ? "N" : "Y";
	
	
	
	boolean isSearch = type ==null || type.equals("") || keyword ==null || keyword.equals("") ? false : true;
	
	//공유타입 채크박스 클릭했을때 
			
			//공유 판별
			String shareType = shareTypeCheck==null || shareTypeCheck.equals("") ? "":"Y";
			
			boolean isShare =  shareTypeCheck==null || shareTypeCheck.equals("") ? false : true;
	
	Content con= new Content();
	con.setConTitle(title);
	con.setConText(context);
	con.setConShare(conShare);
	con.setContentNo(no);
	con.setConFile(fileName);
	con.setUserId(writer);
	
	
	ListDao Ldao = new ListDao();
	Ldao.updateContent(con);
	
	
	req.setAttribute("pageNum", pageNum);
	session.setAttribute("id",writer);
	
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
	req.setAttribute("isFile",isFile);
	
	resp.sendRedirect("imgList?no="+no+ "&pageNum="+pageNum+"&type="+type+"&keyword="+keyword+"&shareType="+shareType);
	}	
	
	
}

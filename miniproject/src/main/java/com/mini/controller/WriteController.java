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

@WebServlet("/writeProcess")
public class WriteController extends HttpServlet{
	
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
	
	
	// 파일이 있는지 없는지 확인
	String conFile = req.getParameter("WconFile");
	boolean isFile = conFile ==null || conFile.equals("") ? false : true;
	
	String conShareCheck = null,title = null, context = null, writer=null ,fileName=null;

	System.out.println(conFile);
	//파일이 있을 경우
	if(!isFile) {
	MultipartRequest multi = new MultipartRequest(req,realPath,maxFileSize, 
						encoding,new DefaultFileRenamePolicy());
	
	title = multi.getParameter("Wtitle");
	context = multi.getParameter("Wcontext");
	writer = (String)session.getAttribute("id");
	conShareCheck=multi.getParameter("WconShare");
	fileName = multi.getFilesystemName("WconFile");
	
	
	}
	
	
	//// 파일이 없을경우
	if(isFile) {
	req.setCharacterEncoding("UTF-8");
	resp.setCharacterEncoding("utf-8");
	
	title = req.getParameter("Wtitle");
	context = req.getParameter("Wcontext");
	writer = (String)session.getAttribute("id");
	conShareCheck=req.getParameter("WconShare");


	}
	String conShare = conShareCheck ==null ? "N" : "Y";
	
	Content con= new Content();
	con.setConTitle(title);
	con.setConText(context);
	con.setConShare(conShare);
	con.setConFile(fileName);
	con.setUserId(writer);
	
	
	
	ListDao Ldao = new ListDao();
	Ldao.insertContent(con);
	
	
	
	
	
	req.setAttribute("isFile",isFile);
	
	resp.sendRedirect("imgList");
	}	
	
	
}

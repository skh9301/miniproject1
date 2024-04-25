package com.mini.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mini.project.Content;
import com.mini.project.Member;

public class LogDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	
	public LogDao() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds=(DataSource) envContext.lookup("jdbc/bbsDBPool");
		}catch(NamingException e) {}
	}
	
	// 회원가입 창	
	public void insertMember(Member member){
		String sqlInsert = "insert into member values ( ?,?,?,?,?)";
		Member m = null;
		try {
			conn= ds.getConnection();
			pstmt=conn.prepareStatement(sqlInsert);
			pstmt.setString(1,member.getUserId());
			pstmt.setString(2,member.getPass());
			pstmt.setString(3,member.getNickName());
			pstmt.setString(4,member.getmPhone());
			pstmt.setString(5,member.geteMail());
			pstmt.executeUpdate();
			System.out.println(member.geteMail());
			
		}catch(SQLException e) {
			
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		
	}
	// 로그인 창 
	
	public Member getMember(String userId, String pass){
		String sqlSelect = "select * from member where userId = ? and pass=?";
		Member m = null;
		try {
			conn= ds.getConnection();
			pstmt=conn.prepareStatement(sqlSelect);
			pstmt.setString(1,userId);
			pstmt.setString(2,pass);
			rs =pstmt.executeQuery();
			
		
			
			if(rs.next()) {
				m = new Member();
				m.setUserId(rs.getString("userId"));
				m.setPass(rs.getString("pass"));
				m.setNickName(rs.getString("nickName"));
			}
		}catch(SQLException e) {
			
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		return m;
	}
}

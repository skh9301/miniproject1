package com.mini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mini.project.Content;

public class ListDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	
	public ListDao() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds=(DataSource) envContext.lookup("jdbc/bbsDBPool");
		}catch(NamingException e) {}
	}
	
	public ArrayList<Content> getList(){
		String sqlSelect = "select * from content order by content_no";
		ArrayList cList = null;
		try {
			conn= ds.getConnection();
			pstmt=conn.prepareStatement(sqlSelect);
			rs=pstmt.executeQuery();
			cList = new ArrayList();
			
			while(rs.next()) {
				Content c= new Content();
				c.setContentNo(rs.getInt("content_no"));
				c.setUserId(rs.getString("userID"));
				c.setConTitle(rs.getString("con_title"));
				c.setConReDate(rs.getTimestamp("con_re_date"));
				c.setConText(rs.getString("con_text"));
				c.setConFile(rs.getString("con_file"));
				c.setConCount(rs.getInt("con_count"));
				c.setConGood(rs.getInt("con_good"));
				c.setConBad(rs.getInt("con_bad"));
				c.setConShare( rs.getString("con_share"));
				
				cList.add(c);
			}
			
		}catch(SQLException e) {
			
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		
		return cList;
	}
	
	public Content getList(int no){
		String sqlSelect = "select * from content where content_no=?";
		Content c =null;
		ArrayList cList = null;
		try {
			conn= ds.getConnection();
			pstmt=conn.prepareStatement(sqlSelect);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				c= new Content();
				c.setContentNo(rs.getInt("content_no"));
				c.setUserId(rs.getString("userID"));
				c.setConTitle(rs.getString("con_title"));
				c.setConReDate(rs.getTimestamp("con_re_date"));
				c.setConText(rs.getString("con_text"));
				c.setConFile(rs.getString("con_file"));
				c.setConCount(rs.getInt("con_count"));
				c.setConGood(rs.getInt("con_good"));
				c.setConBad(rs.getInt("con_bad"));
				c.setConShare( rs.getString("con_share"));
				
			}
			
		}catch(SQLException e) {
			
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		
		return c;
	}
}

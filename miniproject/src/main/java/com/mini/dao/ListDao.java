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
import com.mini.project.Member;

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
	
	
	
	//전체 게시글 수
	public int getCount(){
		String sqlSelect = "select count(*) from content";
		int count=0;
		try {
			conn= ds.getConnection();
			pstmt=conn.prepareStatement(sqlSelect);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
			}
		}catch(SQLException e) {
			
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		
		return count;
	}
	
	// 검색일때 카운트
	public int getCount(String type , String keyword){
		String sqlSelect = "select count(*) from content where " + type + "  like ?";
		int count=0;
		try {
			conn= ds.getConnection();
			pstmt=conn.prepareStatement(sqlSelect);
			pstmt.setString(1, "%"+keyword+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		
		return count;
	}
	// 공유일때 카운트
	public int getCount(String isShare){
		String sqlSelect = "select count(*) from content where con_share  like ?";
		int count=0;
		try {
			conn= ds.getConnection();
			pstmt=conn.prepareStatement(sqlSelect);
			pstmt.setString(1, "%"+isShare+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		
		return count;
	}
	// 공유 o 검색 o 카운트
	public int getCount(String isShare , String type , String keyword){
		String sqlSelect = "select count(*) from content where "+ type + " like ? and con_share  like ?";
		int count=0;
		try {
			conn= ds.getConnection();
			pstmt=conn.prepareStatement(sqlSelect);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+isShare+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		
		return count;
	}
	
	//게시글을 리스트로 뿌려줌 검색아닐경우
	public ArrayList<Content> getList( int startRow, int endRow){
		
		
		String sqlSelect = "select * from (select rownum num, sub.* from (select * from content  order by content_no desc ) sub) where num between ? and ?";
		
		
		ArrayList cList = null;
		try {
			conn= ds.getConnection();
			pstmt=conn.prepareStatement(sqlSelect);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			cList = new ArrayList();
			
			while(rs.next()) {
				Content c= new Content();
				c.setContentNo(rs.getInt("content_no"));
				c.setUserId(rs.getString("userID"));
				c.setConTitle(rs.getString("con_title"));
				c.setConReDate(rs.getTimestamp("con_re_date"));
				c.setConText(rs.getString("con_text"));
				c.setConCount(rs.getInt("con_count"));
				c.setConGood(rs.getInt("con_good"));
				c.setConBad(rs.getInt("con_bad"));
				c.setConShare( rs.getString("con_share"));
				c.setConFile( rs.getString("con_file"));
				
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
	
	//게시글을 리스트로 뿌려줌 검색아닐경우 + 공유할경우
	public ArrayList<Content> getList(String shareType, int startRow, int endRow){
		
		
		String sqlSelect = "select * from (select rownum num, sub.* from (select * from content where con_share like ? order by content_no desc) sub) where num between ? and ?";	
		
		ArrayList cList = null;
		try {
			conn= ds.getConnection();
			pstmt=conn.prepareStatement(sqlSelect);
			pstmt.setString(1, "%"+shareType+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs=pstmt.executeQuery();
			cList = new ArrayList();
			
			while(rs.next()) {
				Content c= new Content();
				c.setContentNo(rs.getInt("content_no"));
				c.setUserId(rs.getString("userID"));
				c.setConTitle(rs.getString("con_title"));
				c.setConReDate(rs.getTimestamp("con_re_date"));
				c.setConText(rs.getString("con_text"));
				c.setConCount(rs.getInt("con_count"));
				c.setConGood(rs.getInt("con_good"));
				c.setConBad(rs.getInt("con_bad"));
				c.setConShare( rs.getString("con_share"));
				c.setConFile( rs.getString("con_file"));
				
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
	
	//게시글을 리스트로 뿌려줌 검색일경우
		public ArrayList<Content> getList(String type,String keyword, int startRow, int endRow){
			
			String sqlSelect =  "select * from (select rownum num, sub.* from (select * from content  where "+type+"  like ?) sub) where num  between ? and ?";
			
			
			
			ArrayList cList = null;
			try {
				conn= ds.getConnection();
				pstmt=conn.prepareStatement(sqlSelect);
				pstmt.setString(1, "%"+keyword +"%");
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rs=pstmt.executeQuery();
				cList = new ArrayList();
				
				while(rs.next()) {
					Content c= new Content();
					c.setContentNo(rs.getInt("content_no"));
					c.setUserId(rs.getString("userID"));
					c.setConTitle(rs.getString("con_title"));
					c.setConReDate(rs.getTimestamp("con_re_date"));
					c.setConText(rs.getString("con_text"));
					c.setConCount(rs.getInt("con_count"));
					c.setConGood(rs.getInt("con_good"));
					c.setConBad(rs.getInt("con_bad"));
					c.setConShare( rs.getString("con_share"));
					c.setConFile( rs.getString("con_file"));
					
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
		
		//게시글을 리스트로 뿌려줌 검색일경우 + 공유할경우
		public ArrayList<Content> getList(String type,String keyword,String shareType, int startRow, int endRow){
			
			String sqlSelect =  "select * from (select rownum num, sub.* from (select * from content  where "+type+"  like ? and con_share like ?) sub) where num  between ? and ?";
			
			ArrayList cList = null;
			try {
				conn= ds.getConnection();
				pstmt=conn.prepareStatement(sqlSelect);
				pstmt.setString(1, "%"+keyword +"%");
				pstmt.setString(2, "%"+shareType +"%");
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
				rs=pstmt.executeQuery();
				cList = new ArrayList();
				
				while(rs.next()) {
					Content c= new Content();
					c.setContentNo(rs.getInt("content_no"));
					c.setUserId(rs.getString("userID"));
					c.setConTitle(rs.getString("con_title"));
					c.setConReDate(rs.getTimestamp("con_re_date"));
					c.setConText(rs.getString("con_text"));
					c.setConCount(rs.getInt("con_count"));
					c.setConGood(rs.getInt("con_good"));
					c.setConBad(rs.getInt("con_bad"));
					c.setConShare( rs.getString("con_share"));
					c.setConFile( rs.getString("con_file"));
					
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
	
	
	
	//디테일 게시글 - 해당 넘버에 게시글 불러옴
	public ArrayList<Object>  getList(int no){
		String sqlSelect = "SELECT con.*, mem.nickName FROM content con INNER JOIN member mem ON con.userId = mem.userId "
				+ "WHERE con.content_no = ?";
		Content c =null;
		Member m  =null;
		 ArrayList<Object> List = new ArrayList<>();
		try {
			conn= ds.getConnection();
			pstmt=conn.prepareStatement(sqlSelect);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				c= new Content();
				m=new Member();
				c.setContentNo(rs.getInt("content_no"));
				c.setUserId(rs.getString("userID"));
				m.setNickName(rs.getString("nickName"));
				c.setConTitle(rs.getString("con_title"));
				c.setConReDate(rs.getTimestamp("con_re_date"));
				c.setConText(rs.getString("con_text"));
				c.setConFile(rs.getString("con_file"));
				c.setConCount(rs.getInt("con_count"));
				c.setConGood(rs.getInt("con_good"));
				c.setConBad(rs.getInt("con_bad"));
				c.setConShare( rs.getString("con_share"));
				List.add(m);
				List.add(c);
			}
			
		}catch(SQLException e) {
			
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		
		return List;
	}
	
	
	public void updateBad(int bad, int no) {
	    String sqlUpdate = "UPDATE content SET con_bad=? WHERE content_no=?";
	    
	    try {
	        conn = ds.getConnection();
	        pstmt = conn.prepareStatement(sqlUpdate);
	        pstmt.setInt(1, bad);
	        pstmt.setInt(2, no);
	        pstmt.executeUpdate();
	    } catch(SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // 리소스 해제
	        try {
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	public void updateGood(int good, int no) {
		String sqlUpdate = "UPDATE content SET con_good=? WHERE content_no=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setInt(1, good);
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			// 리소스 해제
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 글쓰기 메서드
	public void insertContent(Content con){
		String sqlInsert = "insert into content (content_no, userID,con_title, con_text,con_share, con_file,con_re_date) values (content_seq.nextval, ?,?, ?,? ,?,sysdate)";
		try {
			conn= ds.getConnection();
			pstmt=conn.prepareStatement(sqlInsert);
			pstmt.setString(1,con.getUserId());
			pstmt.setString(2,con.getConTitle());
			pstmt.setString(3,con.getConText());
			pstmt.setString(4,con.getConShare());
			pstmt.setString(5,con.getConFile());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		
	}
	
	// 업데이트 메서드
		public void updateContent(Content con){
			String fileUpdate=con.getConFile() !=null ? "con_file=?, " : "";
			String sqlUpdate = "update content set con_title=? ,con_text=? ,"+ fileUpdate +"con_share=? where content_no=?";
			try {
				conn= ds.getConnection();
				pstmt=conn.prepareStatement(sqlUpdate);
				pstmt.setString(1,con.getConTitle());
				pstmt.setString(2,con.getConText());
				if(con.getConFile()!=null) {
					pstmt.setString(3,con.getConFile());
					pstmt.setString(4,con.getConShare());
					pstmt.setInt(5,con.getContentNo());
				}else {
					pstmt.setString(3,con.getConShare());
					pstmt.setInt(4,con.getContentNo());
				}
				
				pstmt.executeUpdate();
			}catch(SQLException e) {
				
			}finally {
				try {
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				}catch(Exception e) {}
			}
			
		}
	
	//글 삭제 메서드
	public void deleteContent(int no){
		String sqlInsert = "delete content where content_no=?";
		try {
			conn= ds.getConnection();
			pstmt=conn.prepareStatement(sqlInsert);
			pstmt.setInt(1,no);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		
	}
}

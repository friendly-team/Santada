package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.JDBCTemplate;
import member.model.vo.Member;

public class MemberDAO {

	public int insertMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO MEMBER VALUES(?,?,?,?,?,0,0,DEFAULT)"; 
		
		try {
			pstmt = conn.prepareStatement(query); 
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getUserPhone());
			pstmt.setString(5, member.getUserEmail());
			
			result = pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Member selectOneLogin(Connection conn, String userId, String userPwd) {
		Statement stmt = null;
		ResultSet rset = null;
		Member member = null;
		String query = "SELECT * FROM MEMBER WHERE USER_ID ='" 
		+ userId + "' AND USER_PWD ='" + userPwd + "'";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				member = new Member();
				member.setUserId(rset.getString("USER_ID"));
				member.setUserName(rset.getString("USER_NAME"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return member;
	}

	public Member selectOneLogin(Connection conn, String userName, String userEmail, String userPhone) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT USER_ID, ENROLL_DATE FROM MEMBER WHERE USER_NAME=? AND USER_EMAIL=? AND USER_PHONE=?";
		Member idOne = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, userEmail);
			pstmt.setString(3, userPhone);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				idOne = new Member();
				idOne.setUserId(rset.getString("USER_ID"));
				idOne.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return idOne;
	}

	public int selectPwdOne(Connection conn, String userId, String userName, String userEmail) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "SELECT USER_PWD FROM MEMBER WHERE USER_ID=? AND USER_NAME=? AND USER_EMAIL=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userName);
			pstmt.setString(3, userEmail);
			
			result = pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updatePwdOne(Connection conn, String userPwd, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MEMBER SET USER_PWD =? WHERE USER_ID=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userPwd);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Member selectOneMember(Connection conn, String writerId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MEMBER WHERE USER_ID = ?";
		Member member = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, writerId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				member.setUserId(rset.getString("USER_ID"));
				member.setUserPwd(rset.getString("USER_PWD"));
				member.setUserName(rset.getString("USER_NAME"));
				member.setUserEmail(rset.getString("USER_EMAIL"));
				member.setUserPhone(rset.getString("USER_PHONE"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return member;
	}

	public Member getSearchLogin(Connection conn, String userId) {
		Statement stmt = null;
		ResultSet rset = null;
		Member member = null;
		String query = "SELECT * FROM MEMBER WHERE USER_ID ='" 
		+ userId + "'";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				member = new Member();
				member.setUserId(rset.getString("USER_ID"));
				member.setUserName(rset.getString("USER_NAME"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return member;
	}
}

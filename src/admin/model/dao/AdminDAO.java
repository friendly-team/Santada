package admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import member.model.vo.Member;
import report.model.vo.Report;

public class AdminDAO {
	
	
	// 회원관리 -> 삭제
	public int deleteMember(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM MEMBER WHERE USER_ID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			// 쿼리문 실행 ???
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
	// 나무 포인트 처리 (완료 버튼을 누르면 add point 처리되게끔 해주고, 목록에서 삭제 시킴 = 업데이트 or 수정기능 활용하면 될듯)
	 //1. 포인트 처리
	public int updateMember(Connection conn, Member member) {
		int result = 0;
		// PreparedStatement 객체
		PreparedStatement pstmt = null;
		
		// 쿼리문 작성
		String query = "UPDATE MEMBER SET TREE_POINT = TREE_POINT + 100";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, member.getTreePoint());
			// 쿼리문 실행
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원해제
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	// 신고관리 처리 (처리->글 자체를 삭제 해줌, 대기-> 대기중이라고 값만 바꿔줌)
	public int deleteReport(Connection conn, int reportNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE FROM MEMBER WHERE REPORT_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reportNo);
			// 쿼리문 실행 ???
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	public Report selectReport(Connection conn, int reportNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Report report=null;
		String query = "SELECT * FROM REPORT WHERE REPORT_NO = ?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, reportNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				report = new Report();
				report.setPostNo(rset.getInt("POST_NO"));
				report.setPostType(rset.getString("POST_TYPE"));
				report.setReportContents(rset.getString("REPORT_CONTENTS"));
				report.setReportTitle(rset.getString("REPORT_TITLE"));
				report.setUserId(rset.getString("USER_ID"));
				report.setReportType(rset.getString("REPORT_TYPE"));
				report.setReportNo(rset.getInt("REPORT_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return report;
	}

}

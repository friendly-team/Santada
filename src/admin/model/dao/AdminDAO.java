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

	public int updatePostState(Connection conn, String postState, int mPostNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE MOUNTAIN_POST SET MOUNTAIN_POST_STATE = '승인' WHERE MOUNTAIN_POST_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mPostNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updatePoint(Connection conn, Member member, String postState, String mPostWriter) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE MEMBER SET TREE_POINT = ? + 10, NORMAL_POINT = ? + 10 WHERE USER_ID = ?";
		try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, member.getTreePoint());
				pstmt.setInt(2, member.getNormalPoint());
				pstmt.setString(3, mPostWriter);
				result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	public Member selectPoint(Connection conn, String mPostWriter) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MEMBER WHERE USER_ID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mPostWriter);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new Member();
				member.setTreePoint(rset.getInt("TREE_POINT"));
				member.setNormalPoint(rset.getInt("NORMAL_POINT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return member;
	}

}

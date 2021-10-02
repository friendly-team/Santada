package report.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import member.model.vo.Member;
import report.model.vo.Report;

public class ReportDAO {

	public List<Report> selectOneById(Connection conn, String studentId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM REPORT WHERE USER_ID = ?";
		List<Report> nList = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, studentId);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Report>();
			while(rset.next()) {
				Report report = new Report();
				report = new Report();
				report.setReportNo(rset.getInt("REPORT_NO"));
				report.setUserId(rset.getString("USER_ID"));
				report.setPostType(rset.getString("POST_TYPE"));
				report.setReportType(rset.getString("REPORT_TYPE"));
				report.setReportTitle(rset.getString("REPORT_TITLE"));
				report.setReportContents(rset.getString("REPORT_CONTENTS"));
				report.setAnswer(rset.getString("ANSWER"));
				report.setPostNo(rset.getInt("POST_NO"));
				nList.add(report);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return nList;
	}	public int inserReport(Connection conn, Report report) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query="INSERT INTO REPORT VALUES(SEQ_REPORT.NEXTVAL,?,?,?,?,?,DEFAULT,?,DEFAULT)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, report.getUserId());
			pstmt.setString(2, report.getPostType());
			pstmt.setString(3, report.getReportType());
			pstmt.setString(4, report.getReportTitle());
			pstmt.setString(5, report.getReportContents());
			pstmt.setInt(6, report.getPostNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}
	
	

}
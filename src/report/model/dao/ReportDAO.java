 package report.model.dao;

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
	}

	public int deleteReportList(Connection conn, int[] nums) {
		Statement stmt = null;
		int result = 0;
		String params = "";
		
		for(int i =0; i<nums.length; i++) {
			params += nums[i];
			
			if(i < nums.length-1)
				params += ",";
		}
		
		String query = "DELETE REPORT WHERE REPORT_NO IN ("+params+")";
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(stmt);
		}
		
		return result;
	}

}
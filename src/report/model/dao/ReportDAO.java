 package report.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import club.model.vo.ClubManagement;
import common.JDBCTemplate;
import report.model.vo.Report;

public class ReportDAO {

	public int inserReport(Connection conn, Report report) {
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

	public List<Report> selectAllReport(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM REPORT WHERE USER_ID = ?";
		List<Report> rList = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);	
			rset = pstmt.executeQuery();
			 rList = new ArrayList<Report>();
			while(rset.next()) {
				Report report = new Report();
				report.setAnswer(rset.getString("ANSWER"));
				report.setReportContents(rset.getString("REPORT_CONTENTS"));
				report.setReportDate(rset.getDate("REPORT_DATE"));
				report.setReportTitle(rset.getString("REPORT_TITLE"));
				report.setReportNo(rset.getInt("REPORT_NO"));
				rList.add(report);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return rList;
	}

	public int deleteReport(Connection conn, String[] check) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM REPORT WHERE REPORT_NO = ?";

		
		try {
			for(int i =0;i<check.length;i++) {
			pstmt = conn.prepareStatement(query);
			pstmt.setString (1, check[i]);
			result = pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int totalReportCount(Connection conn) {
    	int totalValue =0;
    	Statement stmt = null;
    	ResultSet rset = null;
    	
    	try {
    		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM REPORT WHERE ANSWER = 'N'";
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				totalValue = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
    	return totalValue;
	}

	public List<Report> selectAdminReport(Connection conn, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY REPORT_DATE ASC) AS NUM,REPORT_NO, USER_ID, POST_TYPE,REPORT_TYPE,REPORT_TITLE,REPORT_CONTENTS,ANSWER,POST_NO, REPORT_DATE FROM REPORT WHERE ANSWER ='N') WHERE NUM BETWEEN ? AND ?";
		List<Report> rList = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			int viewCountPerPage = 10;
			int start = currentPage * viewCountPerPage - (viewCountPerPage-1);
			int end = currentPage * viewCountPerPage;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset=pstmt.executeQuery();
			
			rList = new ArrayList<Report>();
			
			while(rset.next()) {
				Report report = new Report();
				report.setReportNo(rset.getInt("REPORT_NO"));
				report.setAnswer(rset.getString("ANSWER"));
				report.setPostNo(rset.getInt("POST_NO"));
				report.setPostType(rset.getString("POST_TYPE"));
				report.setUserId(rset.getString("USER_ID"));
				report.setReportDate(rset.getDate("REPORT_DATE"));
				report.setReportContents(rset.getString("REPORT_CONTENTS"));
				report.setReportTitle(rset.getString("REPORT_TITLE"));
				report.setAnswer(rset.getString("ANSWER"));
				report.setPostNo(rset.getInt("POST_NO"));
				rList.add(report);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return rList;
	}

	public String ReportPageNavi(Connection conn, int currentPage) {
		 int pageCountPerView = 5;
	      int viewTotalCount = totalReportCount(conn);
	      int viewCountPerPage = 10;
	      int pageTotalCount = 0;
	      int pageTotalCountMod = viewTotalCount % viewCountPerPage;
	      if(pageTotalCountMod > 0) {
	         pageTotalCount = viewTotalCount / viewCountPerPage + 1;
	      }else {
	         pageTotalCount = viewTotalCount / viewCountPerPage;
	      }
	      int startNavi = ((currentPage - 1) / pageCountPerView) * pageCountPerView + 1;
	      int endNavi = startNavi + pageCountPerView - 1;
	      if(endNavi > pageTotalCount) {
	         endNavi = pageTotalCount;
	      }
	      boolean needPrev = true;
	      boolean needNext = true;
	      if (startNavi == 1) {
	         needPrev = false;
	      }if(endNavi == pageTotalCount) {
	         needNext = false;
	      }
	      StringBuilder sb = new StringBuilder();
	      if(needPrev) {
	         sb.append("<a href='/admin/report?currentPage=" + (startNavi - 1) + "'> <</a>");
	      }
	      for(int i = startNavi; i <= endNavi; i++) {
	         if(i == currentPage) {
	            sb.append(i);
	         }else {
	            sb.append("<a href='/admin/report?currentPage=" + i +"'>" + i + "</a>");
	         }
	      }
	      if (needNext) {
	         sb.append("<a href='/admin/report?currentPage=" + (endNavi + 1) + "'> > </a>");
	      }
	      return sb.toString();
	}

	public int updateAnswer(Connection conn, int reportNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String qeury="UPDATE REPORT SET ANSWER = 'Y' WHERE REPORT_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(qeury);
			pstmt.setInt(1, reportNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
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

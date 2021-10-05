package report.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import common.JDBCTemplate;
import report.model.dao.ReportDAO;
import report.model.vo.PageData;
import report.model.vo.Report;

public class ReportService {
	private JDBCTemplate jdbcTemplate;
	public ReportService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}
	public int writeReport(Report report) {
		Connection conn = null;
		int result = 0;
		try {
			conn = jdbcTemplate.createConnection();
			result = new ReportDAO().inserReport(conn,report);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}

	public List<Report> printAllReport(String userId) {
		Connection conn = null;
		List<Report> rList = null;
		try {
			conn = jdbcTemplate.createConnection();
			rList = new ReportDAO().selectAllReport(conn,userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return rList;
	}

	public int removeReport(String[] check) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new ReportDAO().deleteReport(conn,check);
			
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public PageData printAdminReport(int currentPage) {
		Connection conn = null;
		PageData pd = new PageData();
		ReportDAO rDAO = new ReportDAO();
		
		try {
			conn = jdbcTemplate.createConnection();
			rDAO.totalReportCount(conn);
			pd.setrList(rDAO.selectAdminReport(conn,currentPage));
			pd.setPageNavi(rDAO.ReportPageNavi(conn, currentPage));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return pd;
	}
	
	public int modifyAnswer(int reportNo) {
		Connection conn = null;
		int result = 0;
		try {
			conn = jdbcTemplate.createConnection();
			result = new ReportDAO().updateAnswer(conn,reportNo);
			
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}

	public int deleteReport(int[] nums) {
		Connection conn = null;
		int result = 0;
		try {
			conn = jdbcTemplate.createConnection();
			result = new ReportDAO().deleteReportList(conn, nums);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

}

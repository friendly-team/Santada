package admin.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import admin.model.dao.AdminDAO;
import common.JDBCTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.Member;
import report.model.vo.Report;

public class AdminService {
	
	private JDBCTemplate jdbcTemplate;
	
	public AdminService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}
	
	public Report printReport(int reportNo) {
		Report report = null;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			report = new AdminDAO().selectReport(conn,reportNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return report;
	}

	public int modifyPoint(String postState, String mPostWriter, int mPostNo) {
		int sum = 0;
		int pResult = 0;
		int sResult = 0;
		Member member = new Member();
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			if(postState.equals("승인")) {
				sResult = new AdminDAO().updatePostState(conn, postState, mPostNo);
				if(sResult > 0) {
					JDBCTemplate.commit(conn);
				} else {
					JDBCTemplate.rollback(conn);
				}
				member = new AdminDAO().selectPoint(conn, mPostWriter);
				pResult = new AdminDAO().updatePoint(conn, member, postState, mPostWriter);
				if(pResult > 0) {
					JDBCTemplate.commit(conn);
				} else {
					JDBCTemplate.rollback(conn);
				}
				sum = pResult + sResult;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return sum;
	}

}

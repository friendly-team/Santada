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
	
	// 회원관리 -> 삭제
	public int deleteMember(String userId) {
		int result = 0;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			result = new AdminDAO().deleteMember(conn, userId);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	// 나무 포인트 처리 (완료 버튼을 누르면 add point 처리되게끔 해주기 = 업데이트 or 수정기능 활용하면 될듯)
	public int addTreepoint(Member member) {
		int result = 0;
		Connection conn = null;
		try {
			// 연결 생성하고
			conn = jdbcTemplate.createConnection();
			result = new AdminDAO().updateMember(conn, member);
			// 성공,실패 여부에 따라 커밋/롤백
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	// 신고관리 처리 (처리->글 자체를 삭제 해줌, 대기-> 대기중이라고 값만 바꿔줌)
	public int deleteReport(int reportNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			result = new AdminDAO().deleteReport(conn, reportNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
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
				sResult = new AdminDAO().uodatePostState(conn, postState, mPostNo);
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

package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.JDBCTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.Member;


public class MemberService {

	private JDBCTemplate jdbcTemplate;
	
	public MemberService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	};
	public int registerMember(Member member) {
		int result = 0;

		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection(); 
			result = new MemberDAO().insertMember(conn, member);

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
	public Member printOneLogin(String userId, String userPwd) {
		Member Member = null;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			Member = new MemberDAO().selectOneLogin(conn, userId, userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return Member;
	}
	public Member findMemberId(String userName, String userEmail, String userPhone) {
		Connection conn = null;
		Member idOne = null;
		try {
			conn = jdbcTemplate.createConnection();
			idOne = new MemberDAO().selectOneLogin(conn, userName, userEmail, userPhone);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return idOne;
	}
	public int findMemberPwd(String userId, String userName, String userEmail) {
		int result = 0;

		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection(); 
			result = new MemberDAO().selectPwdOne(conn, userId, userName, userEmail);

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
	public int changeMemberPwd(String userPwd, String userId) {
		int result = 0;

		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection(); 
			result = new MemberDAO().updatePwdOne(conn, userPwd, userId);

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
	public Member printOneById(String writerId) {
		Member member = null;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			member = new MemberDAO().selectOneMember(conn, writerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return member;
	}
}

package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
	public Member printOneById(String studentId) {
		Member student = null;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection(); // 연결생성함
			student = new MemberDAO().selectOneById(conn, studentId); // 연결 넘겨줌
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return student;
	}
	public int modifyStudent(Member student) {
		int result = 0;
		Connection conn = null;
		try {
			// 연결 생성하고
			conn = jdbcTemplate.createConnection();
			result = new MemberDAO().updateMember(conn, student);
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
	public int deleteMember(String studentId) {
		int result = 0;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			result = new MemberDAO().deleteMember(conn, studentId);
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
	public Member printPointById(String studentId) {
		Member student = null;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection(); // 연결생성함
			student = new MemberDAO().selectPointById(conn, studentId); // 연결 넘겨줌
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return student;
	}
	
	
	public List<Member> printAllList() {
			Connection conn = null;
			List<Member> mList = null;
			
			try {
				conn = jdbcTemplate.createConnection();
				mList = new MemberDAO().selectAllList(conn);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(conn);
			}
			
			return mList;
		}
	

	
	
}

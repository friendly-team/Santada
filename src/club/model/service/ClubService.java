	package club.model.service;

	import java.sql.Connection;
	import java.sql.SQLException;

	import club.model.dao.ClubDAO;
	import club.model.vo.ClubManagement;
import club.model.vo.PageData;
import common.JDBCTemplate;
import club.model.vo.Club;


public class ClubService {
	
	private JDBCTemplate jdbcTemplate;
	public ClubService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}
	public int createClub(Club club, int userAge) {
		int result = 0;
		int result2 = 0;
		int sum = 0;
		ClubDAO cDao = new ClubDAO();
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			result = cDao.insertClub(conn, club);
			int clubNo = cDao.selectOneClub(conn,club.getUserId());
			String userName = cDao.selectOneById(conn, club.getUserId());
			result2 = cDao.insertManagement(conn,club.getUserId(), userAge, userName, clubNo);
			sum = result + result2;
			if(sum > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return sum;
	}

		public int ClubJoin(ClubManagement club) {
			int result = 0;
			Connection conn = null;
			try {
				conn = jdbcTemplate.createConnection();
				ClubDAO cDao = new ClubDAO();
				
				String userName = cDao.selectOneById(conn, club.getUserId());
				int clubNo = cDao.selectClubNo(conn,club.getClubName());
				if(clubNo > 0) {
					result = cDao.joinClub(conn,club,userName,clubNo);
				}
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
		public ClubManagement printOneId(String userId) {
			ClubManagement cm = null;
			Connection conn = null;
			
			try {
				conn = jdbcTemplate.createConnection();
				cm = new ClubDAO().joinCheck(conn, userId);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(conn);
			}
			
			return cm;
		}
		public Club printBossCheck(String userId) {
			Club club = null;
			Connection conn = null;
			
			try {
				conn = jdbcTemplate.createConnection();
				club = new ClubDAO().selectBossIdCheck(conn,userId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return club;
		}
		public int removeClub(String userId) {
			int result = 0;
			
			int clubNo = 0;
			Connection conn = null;
			try {
				conn=jdbcTemplate.createConnection();
				clubNo = new ClubDAO().selectUserClubNo(conn, userId);
				result = new ClubDAO().deleteClub(conn, clubNo);
				new ClubDAO().deleteCM(conn,clubNo);
				
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
		public PageData printAllJoin(int currentPage, String userId) {
			PageData pd = new PageData();
			Connection conn = null;
			ClubDAO cDAO = new ClubDAO();
			int clubNo = 0;

			try {
				conn = jdbcTemplate.createConnection();
				clubNo = new ClubDAO().selectUserClubNo(conn, userId);
				cDAO.totalCount(conn,clubNo);
				
				pd.setCmList(cDAO.selectAllJoin(conn,currentPage,clubNo));
				pd.setPageNavi(cDAO.getPageNavi(conn, currentPage,clubNo));
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(conn);
			}
			return pd;
		}
		public ClubManagement printJoinDetail(String userId) {
			ClubManagement cm = null;
			Connection conn = null;
			
			try {
				conn = jdbcTemplate.createConnection();
				cm = new ClubDAO().selectJoinDetail(conn, userId);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(conn);
			}
			return cm;
		}
		public int modifyPosition(String userId) {
			Connection conn = null;
			int result = 0;
			try {
				conn = jdbcTemplate.createConnection();
				result = new ClubDAO().updatePostion(conn, userId);
				if(result > 0) {
					JDBCTemplate.commit(conn);
				}else {
					JDBCTemplate.rollback(conn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(conn);
			}
			return result;
		}
		public int removeJoin(String userId) {
			Connection conn = null;
			int result = 0;
			
			try {
				conn = jdbcTemplate.createConnection();
				result = new ClubDAO().deleteJoin(conn,userId);
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


}
	

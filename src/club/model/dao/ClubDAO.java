

	package club.model.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;

	import java.sql.SQLException;

	import club.model.vo.ClubManagement;
	import common.JDBCTemplate;
	
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import club.model.vo.Club;


public class ClubDAO {

	public int insertClub(Connection conn, Club club) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO CLUB VALUES(SEQ_CLUB.NEXTVAL,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, club.getUserId());
			pstmt.setString(2, club.getClubName());
			pstmt.setString(3, club.getClubRegion());
			pstmt.setInt(4, club.getClubAge());
			pstmt.setString(5, club.getClubIntroduce());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int selectOneClub(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Club club = new Club();
		String query = "SELECT * FROM CLUB WHERE USER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				club.setClubNo(rset.getInt("CLUB_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return club.getClubNo();
	}

	public String selectOneById(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MEMBER WHERE USER_ID = ?";
		String userName = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				userName = rset.getString("USER_NAME");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return userName;
	}

	public int insertManagement(Connection conn, String userId, int userAge, String userName, int clubNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO CLUB_MANAGEMENT VALUES(?,?,?,?,0,DEFAULT,'Y','소모임장','소모임장')";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, clubNo);
			pstmt.setString(2, userId);
			pstmt.setString(3, userName);
			pstmt.setInt(4, userAge);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int joinClub(Connection conn, ClubManagement club, String userName, int clubNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO CLUB_MANAGEMENT VALUES(?,?,?,?,DEFAULT,DEFAULT,DEFAULT,?,?)";
		
		try {			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, clubNo);
			pstmt.setString(2, club.getUserId());
			pstmt.setString(3, userName);
			pstmt.setInt(4, club.getUserAge());
			pstmt.setString(5, club.getUserIntroduce());
			pstmt.setString(6, club.getJoinRoute());
			result=pstmt.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int selectClubNo(Connection conn, String clubName) {
		PreparedStatement pstmt = null;
		int clubNo = 0;
		ResultSet rset = null;
		String query = "SELECT * FROM CLUB WHERE CLUB_NAME = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, clubName);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				clubNo = rset.getInt("CLUB_NO");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return clubNo;
	}

	public ClubManagement joinCheck(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM CLUB_MANAGEMENT WHERE USER_ID= ?";
		ClubManagement cm = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				cm = new ClubManagement();
				cm.setClubNo(rset.getInt("CLUB_NO"));
				cm.setApprovalPosition(rset.getString("APPROVAL_POSITION"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return cm;
	}

	public Club selectBossIdCheck(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM CLUB WHERE USER_ID = ?";
		Club club = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				club = new Club();
				club.setUserId(rset.getString("USER_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return club;
	}

	public int deleteClub(Connection conn, int clubNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM CLUB WHERE CLUB_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, clubNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteCM(Connection conn, int clubNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM CLUB_MANAGEMENT WHERE CLUB_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, clubNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int selectUserClubNo(Connection conn ,String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int clubNo = 0;
		String query = "SELECT * FROM CLUB WHERE USER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				clubNo = rset.getInt("CLUB_NO");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return clubNo;
	}

	public List<ClubManagement> selectAllJoin(Connection conn, int currentPage, int clubNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY JOIN_DATE ASC) AS NUM, USER_ID, USER_NAME, JOIN_DATE, APPROVAL_POSITION FROM CLUB_MANAGEMENT WHERE APPROVAL_POSITION = 'N' AND CLUB_MANAGEMENT.CLUB_NO = ?) WHERE NUM BETWEEN ? AND ?";
		List<ClubManagement> cmList = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			int viewCountPerPage = 10;
			int start = currentPage * viewCountPerPage - (viewCountPerPage-1);
			int end = currentPage * viewCountPerPage;
			pstmt.setInt(1, clubNo);
			pstmt.setInt(2, start); //누른 번호의 값에따라서 변화해야함
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();	//쿼리문 실행후 rset으로 결과값 받기
			
			cmList = new ArrayList<ClubManagement>();
			while(rset.next()) {
				ClubManagement cm = new ClubManagement();
				cm.setApprovalPosition(rset.getString("APPROVAL_POSITION"));
				cm.setUserId(rset.getString("USER_ID"));
				cm.setUserName(rset.getString("USER_NAME"));
				cm.setJoinDate(rset.getDate("JOIN_DATE"));
				cmList.add(cm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return cmList;
	}

	public String getPageNavi(Connection conn, int currentPage, int clubNo) {
	      int pageCountPerView = 5;
	      int viewTotalCount = totalCount(conn,clubNo);
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
	         sb.append("<a href='/clubjoin/management?clubNo="+clubNo+"&currentPage=" + (startNavi - 1) + "'> [이전]</a>");
	      }
	      for(int i = startNavi; i <= endNavi; i++) {
	         if(i == currentPage) {
	            sb.append(i);
	         }else {
	            sb.append("<a href='/clubjoin/management?clubNo="+clubNo+"&currentPage=" + i +"'>" + i + "</a>");
	         }
	      }
	      if (needNext) {
	         sb.append("<a href='/clubjoin/management?clubNo="+clubNo+"&currentPage=" + (endNavi + 1) + "'> [다음] </a>");
	      }
	      return sb.toString();
	   }
	public int totalCount(Connection conn,int clubNo) {
    	int totalValue =0;
    	Statement stmt = null;
    	ResultSet rset = null;
    	
    	try {
    		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM CLUB_MANAGEMENT WHERE CLUB_NO = '"+clubNo+"'AND APPROVAL_POSITION ='N'";
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

	public ClubManagement selectJoinDetail(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ClubManagement cm = null;
		String query = "SELECT * FROM CLUB_MANAGEMENT WHERE USER_ID = ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				cm = new ClubManagement();
				cm.setUserId(rset.getString("USER_ID"));
				cm.setUserName(rset.getString("USER_NAME"));
				cm.setUserAge(rset.getInt("USER_AGE"));
				cm.setJoinDate(rset.getDate("JOIN_DATE"));
				cm.setUserIntroduce(rset.getString("USER_INTRODUCE"));
				cm.setJoinRoute(rset.getString("JOIN_ROUTE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return cm;
	}

	public int updatePostion(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE CLUB_MANAGEMENT SET APPROVAL_POSITION ='Y' WHERE USER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteJoin(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM CLUB_MANAGEMENT WHERE USER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
}


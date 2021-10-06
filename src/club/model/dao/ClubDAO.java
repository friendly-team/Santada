

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
		String query = "INSERT INTO CLUB VALUES(SEQ_CLUB.NEXTVAL,?,?,?,?,?,DEFAULT)";

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
				club.setClubName(rset.getString("CLUB_NAME"));
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
	         sb.append("<a href='/clubjoin/management?clubNo="+clubNo+"&currentPage=" + (startNavi - 1) + "'> <</a>");
	      }
	      for(int i = startNavi; i <= endNavi; i++) {
	         if(i == currentPage) {
	            sb.append(i);
	         }else {
	            sb.append("<a href='/clubjoin/management?clubNo="+clubNo+"&currentPage=" + i +"'>" + i + "</a>");
	         }
	      }
	      if (needNext) {
	         sb.append("<a href='/clubjoin/management?clubNo="+clubNo+"&currentPage=" + (endNavi + 1) + "'> > </a>");
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

	public List<ClubManagement> selectAllMember(Connection conn, int currentPage, int clubNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY JOIN_DATE ASC) AS NUM,CLUB_NO, USER_ID, USER_NAME, JOIN_DATE, USER_POSITION, USER_AGE  FROM CLUB_MANAGEMENT WHERE APPROVAL_POSITION = 'Y' AND CLUB_MANAGEMENT.CLUB_NO = ?) WHERE NUM BETWEEN ? AND ?";
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
				cm.setClubNo(rset.getInt("CLUB_NO"));
				cm.setUserPosition(rset.getInt("USER_POSITION"));
				cm.setUserId(rset.getString("USER_ID"));
				cm.setUserName(rset.getString("USER_NAME"));
				cm.setJoinDate(rset.getDate("JOIN_DATE"));
				cm.setUserAge(rset.getInt("USER_AGE"));
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

	public String memberPageNavi(Connection conn, int currentPage, int clubNo) {
	      int pageCountPerView = 5;
	      int viewTotalCount = membertotalCount(conn,clubNo);
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
	         sb.append("<a href='/club/memberList?clubNo="+clubNo+"&currentPage=" + (startNavi - 1) + "'> <</a>");
	      }
	      for(int i = startNavi; i <= endNavi; i++) {
	         if(i == currentPage) {
	            sb.append(i);
	         }else {
	            sb.append("<a href='/club/memberList?clubNo="+clubNo+"&currentPage=" + i +"'>" + i + "</a>");
	         }
	      }
	      if (needNext) {
	         sb.append("<a href='/club/memberList?clubNo=="+clubNo+"&currentPage=" + (endNavi + 1) + "'> > </a>");
	      }
	      return sb.toString();
	}

	public int membertotalCount(Connection conn, int clubNo) {
    	int totalValue =0;
    	Statement stmt = null;
    	ResultSet rset = null;
    	
    	try {
    		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM CLUB_MANAGEMENT WHERE CLUB_NO = '"+clubNo+"'AND APPROVAL_POSITION ='Y'";
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

	public List<ClubManagement> selectSearchMember(Connection conn, String searchKeyword, int currentPage, int clubNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY JOIN_DATE) AS NUM,CLUB_NO, USER_ID, USER_NAME, JOIN_DATE, USER_POSITION, USER_AGE FROM CLUB_MANAGEMENT WHERE APPROVAL_POSITION = 'Y' AND USER_ID LIKE ? AND CLUB_MANAGEMENT.CLUB_NO = ?) WHERE NUM BETWEEN ? AND ?";
		List<ClubManagement> cmList = null;
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchKeyword+"%");
			pstmt.setInt(2, clubNo);
			int viewCountPerPage = 10;
			int start = currentPage*viewCountPerPage - (viewCountPerPage - 1);
			int end = currentPage*viewCountPerPage;
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			cmList = new ArrayList<ClubManagement>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ClubManagement cm = new ClubManagement();
				cm.setClubNo(rset.getInt("CLUB_NO"));
				cm.setUserPosition(rset.getInt("USER_POSITION"));
				cm.setUserId(rset.getString("USER_ID"));
				cm.setUserName(rset.getString("USER_NAME"));
				cm.setJoinDate(rset.getDate("JOIN_DATE"));
				cm.setUserAge(rset.getInt("USER_AGE"));
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

	public String getSearchPageNavi(Connection conn, String searchKeyword, int currentPage, int clubNo) {
		int pageCountPerView = 5;
		int viewTotalCount = searchTotalCount(conn,searchKeyword,clubNo);
		int viewCountPerPage = 10;
		int pageTotalCount = 0;
		if(viewTotalCount % viewCountPerPage >0) {
			pageTotalCount = viewTotalCount / viewCountPerPage +1;			
		}else {
			pageTotalCount = viewTotalCount / viewCountPerPage;	
		}
		
		int startNavi = ((currentPage -1) / pageCountPerView) * pageCountPerView +1;
		int endNavi = startNavi + pageCountPerView -1;
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}if(endNavi == pageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/club/memberSearch?searchKeyword="+searchKeyword+"&currentPage="+(startNavi-1)+"'> < </a>");
		}
		for(int i=startNavi;i<=endNavi;i++) {
			sb.append("<a href='/club/memberSearch?searchKeyword="+searchKeyword+"&currentPage="+i+"'>"+i+"</a>");
		}if(needNext) {
			sb.append("<a href='/club/memberSearch?searchKeyword="+searchKeyword+"&currentPage="+(endNavi+1)+"'> > </a>");
		}
		
		
		return sb.toString();
	}
	
	public int searchTotalCount(Connection conn, String searchKeyword, int clubNo) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM CLUB_MANAGEMENT WHERE CLUB_NO = '"+clubNo+"'AND APPROVAL_POSITION ='Y' AND USER_ID LIKE '%"+searchKeyword+"%'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				result = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return result;
	}

	public int deleteMember(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		int result = 0 ;
		
		String query = "DELETE FROM CLUB_MANAGEMENT WHERE USER_ID = ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Club selectClubName(Connection conn, int clubNo) {
		PreparedStatement pstmt = null;
		Club club = null;
		String query= "SELECT * FROM CLUB WHERE CLUB_NO =? ";
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, clubNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				club = new Club();
				club.setClubName(rset.getString("CLUB_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}		
		return club;
	}public int selectOneClubNo(Connection conn, String userId) {
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      int clubNo = 0;
	      String query = "SELECT CLUB_NO FROM CLUB_MANAGEMENT WHERE USER_ID = ?";
	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, userId);
	         rset = pstmt.executeQuery();
	         if(rset.next()) {
	            clubNo = rset.getInt("CLUB_NO");
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         JDBCTemplate.close(rset);
	         JDBCTemplate.close(pstmt);
	      }
	      return clubNo;
	   }
	   public String selectOneClubName(Connection conn, int clubNo) {
	      PreparedStatement pstmt = null;
	      String clubName = null;
	      ResultSet rset = null;
	      String query = "SELECT CLUB_NAME FROM CLUB WHERE CLUB_NO = ?";
	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setInt(1, clubNo);
	         rset = pstmt.executeQuery();
	         if(rset.next()) {
	            clubName = rset.getString("CLUB_NAME");
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         JDBCTemplate.close(rset);
	         JDBCTemplate.close(pstmt);
	      }
	      
	      return clubName;
	   }

	   public String selectMasterId(Connection conn, int clubNo) {
	      PreparedStatement pstmt = null;
	      String masterId = null;
	      ResultSet rset = null;
	      String query = "SELECT USER_ID FROM CLUB WHERE CLUB_NO = ?";
	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setInt(1, clubNo);
	         rset = pstmt.executeQuery();
	         if(rset.next()) {
	            masterId=rset.getString("USER_ID");
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         JDBCTemplate.close(rset);
	         JDBCTemplate.close(pstmt);
	      }
	      return masterId;
	   }

	public ClubManagement selectMemberDetail(Connection conn, String userId) {
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
	public List<Club> printAllClub(Connection conn, int currentPage) {
		Statement stmt = null;
		ResultSet rset = null;
		List<Club> cList = null;
		String query = "SELECT * FROM CLUB";
		try {
			stmt = conn.createStatement();
			cList = new ArrayList<Club>();
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				Club club = new Club();
				club.setClubNo(rset.getInt("CLUB_NO"));
				club.setUserId(rset.getString("USER_ID"));
				club.setClubName(rset.getString("CLUB_NAME"));
				club.setClubRegion(rset.getString("CLUB_REGION"));
				club.setClubAge(rset.getInt("CLUB_AGE"));
				club.setClubIntroduce(rset.getString("CLUB_INTRODUCE"));
				club.setClubCreateDate(rset.getDate("CLUB_CREATE_DATE"));
				cList.add(club);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return cList;
	}

	public String getClubPageNavi(Connection conn, int currentPage) {
		int pageCountPerView = 5;
		int viewTotalCount = clubTotalCount(conn, currentPage);
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
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/club/list?currentPage=" + (startNavi - 1) + "'> [이전] </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append(i);
			}else {
				sb.append("<a href='/club/list?currentPage=" + i + "'>" + i + "</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/club/list?currentPage=" + (endNavi + 1) + "'> [다음] </a>");
		}
		return sb.toString();
	}

	private int clubTotalCount(Connection conn, int currentPage) {
		int totalValue = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM CLUB";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				totalValue = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return totalValue;
	}

	public Club printDetailClub(Connection conn, int clubNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Club c = null;
		String query = "SELECT * FROM CLUB WHERE CLUB_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, clubNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				c = new Club();
				c.setClubNo(rset.getInt("CLUB_NO"));
				c.setUserId(rset.getString("USER_ID"));
				c.setClubName(rset.getString("CLUB_NAME"));
				c.setClubRegion(rset.getString("CLUB_REGION"));
				c.setClubAge(rset.getInt("CLUB_AGE"));
				c.setClubIntroduce(rset.getString("CLUB_INTRODUCE"));
				c.setClubCreateDate(rset.getDate("CLUB_CREATE_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return c;
	}

	public int printClubPersonnel(Connection conn, int clubNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM CLUB_MANAGEMENT WHERE CLUB_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, clubNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public List<Club> clubSearch(Connection conn, String keyword, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Club> cList = null;
		String query = "SELECT * FROM CLUB WHERE CLUB_NAME LIKE ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			int viewCountPerPage = 10;
			int start = currentPage * viewCountPerPage - (viewCountPerPage - 1);
			int end = currentPage * viewCountPerPage;
			pstmt.setString(1, "%" + keyword + "%");
			cList = new ArrayList<Club>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Club club = new Club();
				club.setClubNo(rset.getInt("CLUB_NO"));
				club.setUserId(rset.getString("USER_ID"));
				club.setClubName(rset.getString("CLUB_NAME"));
				club.setClubRegion(rset.getString("CLUB_REGION"));
				club.setClubAge(rset.getInt("CLUB_AGE"));
				club.setClubIntroduce(rset.getString("CLUB_INTRODUCE"));
				club.setClubCreateDate(rset.getDate("CLUB_CREATE_DATE"));
				cList.add(club);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return cList;
	}

	public String getClubSearchPageNavi(Connection conn, String keyword, int currentPage) {
		int pageCountPerview = 5;
		int viewTotalCount = clubSearchTotalCount(conn, keyword);
		int viewCountPerPage = 10;
		int pageTotalCount = 0;
		if(viewTotalCount % viewCountPerPage > 0) {
			pageTotalCount = viewTotalCount / viewCountPerPage + 1;
		} else {
			pageTotalCount = viewTotalCount / viewCountPerPage;
		}
		int startNavi = ((currentPage - 1) / pageCountPerview) * pageCountPerview + 1;
		int endNavi = startNavi + pageCountPerview - 1;
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a herf='/club/list?keyword=" + keyword + "&currentPage=" + (startNavi-1) + "'> [이전] </a>");
		}
		for(int i=startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append(i);
			}else {
				sb.append("<a href='/club/list?keyword=" + keyword + "&currentPage=" + i + "'>" + i + "</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/club/list?keyword=" + keyword + "&currentPage=" + (endNavi + 1) + "'> [다음] </a>");
		}
		return sb.toString();
	}

	private int clubSearchTotalCount(Connection conn, String keyword) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM CLUB WHERE CLUB_NAME=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, keyword);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("TOTALCOUNT");
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
}


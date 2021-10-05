package dm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dm.model.vo.Dm;

public class DmDAO {

	public int insertDm(Connection conn, Dm dm) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO DM VALUES(SEQ_LETTER.NEXTVAL,?,?,?,DEFAULT,?)"; 
		
		try {
			pstmt = conn.prepareStatement(query); 
			pstmt.setString(1, dm.getUserId());
			pstmt.setString(2, dm.getLetterContents());
			pstmt.setString(3, dm.getRecipientId());
			pstmt.setString(4, dm.getLetterSubject());
			
			result = pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public List<Dm> selectAllLetter(Connection conn, int currentPage, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(PARTITION BY USER_ID ORDER BY LETTER_NO ASC) AS NUM,LETTER_NO,USER_ID,LETTER_CONTENTS,RECIPIENT_ID,WRITE_DATE,LETTER_SUBJECT FROM DM) t WHERE USER_ID = ? AND NUM BETWEEN ? AND ?";
		List<Dm> nList = null;
		try {
			pstmt = conn.prepareStatement(query);
			int viewCountPerPage = 10;
			int start = currentPage*viewCountPerPage - (viewCountPerPage - 1);
			int end = currentPage*viewCountPerPage;
			pstmt.setString(1, memberId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Dm>();
			while(rset.next()) { 
				Dm Dm = new Dm(); 
				Dm.setLetterNo(rset.getInt("LETTER_NO"));
				Dm.setUserId(rset.getString("USER_ID"));
				Dm.setLetterContents(rset.getString("LETTER_CONTENTS"));
				Dm.setWriteDate(rset.getDate("WRITE_DATE"));
				Dm.setRecipientId(rset.getString("RECIPIENT_ID"));
				nList.add(Dm);
			}
 		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}

	public String getPageNavi(Connection conn, int currentPage, String memberId) {
		int pageCountPerView = 5;
		int viewTotalCount = totalCount(conn, memberId);
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
			sb.append("<li><a class='arrow left' href='/letter/list?currentPage=" 
					+ (startNavi-1) + "'> << </a></li>");
		}
		for(int i=startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append("<li><a class='num' href='/letter/list?currentPage=" + i +"'>" + i + " </a></li>" + " ");
			}else {
				sb.append("<li><a class='num' href='/letter/list?currentPage=" + i +"'>" + i + " </a></li>");
			}
		}
		if(needNext) {
			sb.append("<li><a class='arrow right' href='/letter/list?currentPage=" 
					+ (endNavi+1) + "'> >> </a></li>");
		}
		return sb.toString();
	}

	public int totalCount(Connection conn, String memberId) {
		int totalValue = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM (SELECT ROW_NUMBER() OVER(ORDER BY LETTER_NO DESC) AS NUM, LETTER_NO, USER_ID, LETTER_CONTENTS, RECIPIENT_ID, WRITE_DATE, LETTER_SUBJECT FROM DM) WHERE USER_ID=? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			while(rset.next()) { 
				totalValue = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return totalValue;
	}

	public Dm selectOneByNo(Connection conn, int letterNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Dm LetterOne = null;
		String query = "SELECT * FROM DM WHERE LETTER_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, letterNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				LetterOne = new Dm();
				LetterOne.setLetterNo(rset.getInt("LETTER_NO"));
				LetterOne.setUserId(rset.getString("USER_ID"));
				LetterOne.setLetterSubject(rset.getString("LETTER_SUBJECT"));
				LetterOne.setLetterContents(rset.getString("LETTER_CONTENTS"));
				LetterOne.setWriteDate(rset.getDate("WRITE_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return LetterOne;
	}

	public List<Dm> selectBoxLetter(Connection conn, int currentPage, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(PARTITION BY RECIPIENT_ID ORDER BY LETTER_NO ASC) AS NUM,LETTER_NO,USER_ID,LETTER_CONTENTS,RECIPIENT_ID,WRITE_DATE,LETTER_SUBJECT FROM DM) WHERE RECIPIENT_ID = ? AND NUM BETWEEN ? AND ?";
		List<Dm> bList = null;
		try {
			pstmt = conn.prepareStatement(query);
			int viewCountPerPage = 10;
			int start = currentPage*viewCountPerPage - (viewCountPerPage - 1);
			int end = currentPage*viewCountPerPage;
			pstmt.setString(1, memberId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			bList = new ArrayList<Dm>();
			while(rset.next()) { 
				Dm Dm = new Dm(); 
				Dm.setLetterNo(rset.getInt("LETTER_NO"));
				Dm.setUserId(rset.getString("USER_ID"));
				Dm.setLetterContents(rset.getString("LETTER_CONTENTS"));
				Dm.setWriteDate(rset.getDate("WRITE_DATE"));
				Dm.setRecipientId(rset.getString("RECIPIENT_ID"));
				bList.add(Dm);
			}
 		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return bList;
	}

	public String getPageNaviG(Connection conn, int currentPage, String memberId) {
		int pageCountPerView = 5;
		int viewTotalCount = totalCountTwo(conn, memberId);
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
			sb.append("<li><a class='arrow left' href='/letter/inbox?currentPage=" 
					+ (startNavi-1) + "'> << </a></li>");
		}
		for(int i=startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append("<li><a class='num' href='/letter/inbox?currentPage=" + i +"'>" + i + " </a></li>");
			}else {
				sb.append("<li><a class='num' href='/letter/inbox?currentPage=" + i +"'>" + i + " </a></li>");
			}
		}
		if(needNext) {
			sb.append("<li><a class='arrow right' href='/letter/inbox?currentPage=" 
					+ (endNavi+1) + "'> >> </a></li>");
		}
		return sb.toString();
	}

	private int totalCountTwo(Connection conn, String memberId) {
		int totalValue = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM (SELECT ROW_NUMBER() OVER(ORDER BY LETTER_NO DESC) AS NUM, LETTER_NO, USER_ID, LETTER_CONTENTS, RECIPIENT_ID, WRITE_DATE, LETTER_SUBJECT FROM DM) WHERE RECIPIENT_ID=? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			while(rset.next()) { 
				totalValue = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return totalValue;
	}

	public int deleteLetterOne(Connection conn, int letterNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM DM WHERE LETTER_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, letterNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


		
	
}

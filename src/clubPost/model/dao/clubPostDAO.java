package clubPost.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clubPost.model.vo.ClubPost;
import clubPost.model.vo.ClubPostFile;
import clubPost.model.vo.ClubPostReply;
import common.JDBCTemplate;

public class clubPostDAO {
	public int selectClubNoById(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		int clubNo = 0;
		ResultSet rset = null;
		String query = "SELECT * FROM CLUB_MANAGEMENT WHERE USER_ID=?";
		
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
	
	public int createPost(Connection conn, ClubPost cPost, int clubNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO CLUB_POST VALUES(SEQ_CLUB_POST.NEXTVAL,?,?,0,?,?,DEFAULT)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, clubNo);
			pstmt.setString(2, cPost.getUserId());
			pstmt.setString(3, cPost.getPostSubject());
			pstmt.setString(4, cPost.getPostContents());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int selectPostNo(Connection conn, ClubPost cPost) {
		PreparedStatement pstmt = null;
		int postNo = 0;
		ResultSet rset = null;
		String query = "SELECT * FROM CLUB_POST WHERE USER_ID = ? AND CLUB_POST_SUBJECT=? AND CLUB_POST_CONTENTS=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cPost.getUserId());
			pstmt.setString(2, cPost.getPostSubject());
			pstmt.setString(3, cPost.getPostContents());
			rset=pstmt.executeQuery();
			if(rset.next()) {
				postNo = rset.getInt("CLUB_POST_NO");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return postNo;
	}

	public int insertImg(Connection conn, ClubPostFile clubPostFile, int clubNo, int postNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO CLUB_POST_FILE VALUES(?,?,?,?,?,?,DEFAULT)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, postNo);
			pstmt.setInt(2, clubNo);
			pstmt.setString(3, clubPostFile.getUserId());
			pstmt.setString(4, clubPostFile.getFileName());
			pstmt.setString(5, clubPostFile.getFilePath());
			pstmt.setLong(6, clubPostFile.getFileSize());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public List<ClubPost> printAllClubPost(Connection conn, int currentPage, int clubNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY CLUB_POST_NO DESC)AS NUM, CLUB_NO, CLUB_POST_NO, CLUB_POST_SUBJECT, CLUB_POST_CONTENTS, USER_ID, CLUB_POST_DATE, RECOMMEND FROM CLUB_POST WHERE CLUB_NO = ?) WHERE NUM BETWEEN ? AND ?";
		List<ClubPost> cpList = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			int viewCountPerPage = 10;
			int start = (currentPage * viewCountPerPage) - (viewCountPerPage - 1);
			int end = currentPage * viewCountPerPage;
			pstmt.setInt(1, clubNo);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			cpList = new ArrayList<ClubPost>();
			while(rset.next()) {
				ClubPost cPost = new ClubPost();
				cPost.setPostNo(rset.getInt("CLUB_POST_NO"));
				cPost.setClubNo(rset.getInt("CLUB_NO"));
				cPost.setUserId(rset.getString("USER_ID"));
				cPost.setRecommend(rset.getInt("RECOMMEND"));
				cPost.setPostSubject(rset.getString("CLUB_POST_SUBJECT"));
				cPost.setPostContents(rset.getString("CLUB_POST_CONTENTS"));
				cPost.setWriteDate(rset.getDate("CLUB_POST_DATE"));
				cpList.add(cPost);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return cpList;
	}

	public String getPageNavi(Connection conn, int currentPage, int clubNo) {
		int pageCountPerView = 5;
		int viewTotalCount = totalCount(conn, clubNo);
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
			sb.append("<a href='/clubPost/List?currentPage=" + (startNavi - 1) + "'> [이전]</a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append(i);
			}else {
				sb.append("<a href='/clubPost/List?currentPage=" + i +"'>" + i + "</a>");
			}
		}
		if (needNext) {
			sb.append("<a href='/clubPost/List?currentPage=" + (endNavi + 1) + "'> [다음] </a>");
		}
		return sb.toString();
	}

	private int totalCount(Connection conn, int clubNo) {
		int totalValue = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM CLUB_POST WHERE CLUB_NO  = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, clubNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
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

	public ClubPost printDetailClubPost(Connection conn, int postNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ClubPost cpOne = null;
		String query = "SELECT * FROM CLUB_POST WHERE CLUB_POST_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, postNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				cpOne = new ClubPost();
				cpOne.setPostNo(rset.getInt("CLUB_POST_NO"));
				cpOne.setClubNo(rset.getInt("CLUB_NO"));
				cpOne.setUserId(rset.getString("USER_ID"));
				cpOne.setRecommend(rset.getInt("RECOMMEND"));
				cpOne.setPostSubject(rset.getString("CLUB_POST_SUBJECT"));
				cpOne.setPostContents(rset.getString("CLUB_POST_CONTENTS"));
				cpOne.setWriteDate(rset.getDate("CLUB_POST_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return cpOne;
	}

	public List<ClubPostReply> selectAllPostReply(Connection conn, int postNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM CP_REPLY WHERE CLUB_POST_NO = ?";
		List<ClubPostReply> cpList = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, postNo);
			cpList = new ArrayList<ClubPostReply>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ClubPostReply reply = new ClubPostReply();
				reply.setReplyNo(rset.getInt("REPLY_NO"));
				reply.setPostNo(rset.getInt("CLUB_POST_NO"));
				reply.setReplyContents(rset.getString("REPLY_CONTENTS"));
				reply.setReplyUserId(rset.getString("REPLY_USERID"));
				reply.setReplyDate(rset.getDate("REPLY_DATE"));
				cpList.add(reply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return cpList;
	}

	public String selectPostFile(Connection conn, int postNo) {
		PreparedStatement pstmt = null;
		String fileName = null;
		ResultSet rset = null;
		String query = "SELECT FILE_NAME FROM CLUB_POST_FILE WHERE CLUB_POST_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, postNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				fileName = rset.getString("FILE_NAME");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return fileName;
	}

	public int deleteClubPost(Connection conn, int postNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM CLUB_POST WHERE CLUB_POST_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, postNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteClubFile(Connection conn, String fileName) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM CLUB_POST_FILE WHERE FILE_NAME=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fileName);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateClubPost(Connection conn, ClubPost cp) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE CLUB_POST SET CLUB_POST_SUBJECT = ?, CLUB_POST_CONTENTS=? WHERE CLUB_POST_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cp.getPostSubject());
			pstmt.setString(2, cp.getPostContents());
			pstmt.setInt(3, cp.getPostNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertClubPostReply(Connection conn, ClubPostReply cpReply) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO CP_REPLY VALUES(SEQ_CP_REPLY_NO.NEXTVAL,?,?,?,SYSDATE)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cpReply.getPostNo());
			pstmt.setString(2, cpReply.getReplyContents());
			pstmt.setString(3, cpReply.getReplyUserId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteClubPostReply(Connection conn, int replyNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM CP_REPLY WHERE REPLY_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, replyNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateClubPostReply(Connection conn, int replyNo, String replyContents, int postNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE CP_REPLY SET REPLY_CONTENTS = ? WHERE REPLY_NO = ? AND CLUB_POST_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, replyContents);
			pstmt.setInt(2, replyNo);
			pstmt.setInt(3, postNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int recommendClubPost(Connection conn, int postNo, int recommend) {
		PreparedStatement pstmt = null;
		recommend ++;
		int result = 0;
		String query = "UPDATE CLUB_POST SET RECOMMEND = ? WHERE CLUB_POST_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, recommend);
			pstmt.setInt(2, postNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public List<ClubPost> printSearchClubPost(Connection conn, String searchKeyword, int clubNo, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<ClubPost> cpList = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() "
				+ "OVER(ORDER BY CLUB_POST_NO DESC)AS NUM, CLUB_NO, CLUB_POST_NO, CLUB_POST_SUBJECT,"
				+ " CLUB_POST_CONTENTS, USER_ID, CLUB_POST_DATE, RECOMMEND FROM CLUB_POST WHERE CLUB_POST_SUBJECT LIKE ? AND CLUB_NO = ?)"
				+ " WHERE NUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			int viewCountPerPage = 10; // 한 페이지에 10개의 게시물
			int start = currentPage * viewCountPerPage - (viewCountPerPage - 1);
			int end = currentPage * viewCountPerPage;
			pstmt.setString(1, "%" + searchKeyword + "%");
			pstmt.setInt(2, clubNo);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			cpList = new ArrayList<ClubPost>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ClubPost cp = new ClubPost();
				cp.setPostNo(rset.getInt("CLUB_POST_NO"));
				cp.setClubNo(rset.getInt("CLUB_NO"));
				cp.setUserId(rset.getString("USER_ID"));
				cp.setPostSubject(rset.getString("CLUB_POST_SUBJECT"));
				cp.setPostContents(rset.getString("CLUB_POST_CONTENTS"));
				cp.setRecommend(rset.getInt("RECOMMEND"));
				cp.setWriteDate(rset.getDate("CLUB_POST_DATE"));
				cpList.add(cp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return cpList;
	}

	public String getSearchPageNavi(Connection conn, String searchKeyword, int currentPage, int clubNo) {
		int pageCountPerview = 5;
		int viewTotalCount = searchTotalCount(conn, searchKeyword, clubNo);
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
			sb.append("<a href='/clubPost/List?searchKeyword=" + searchKeyword + "&currentPage=" + (startNavi-1) + "'> [이전] </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append(i);
			}else {
				sb.append("<a href='/clubPost/List?searchKeyword=" + searchKeyword + "&currentPage=" + i + "'>" +  i + " </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/clubPost/List?searchKeyword=" + searchKeyword + "&currentPage=" + (endNavi + 1) + "'> [다음] </a>");
		}
		return sb.toString();
	}

	private int searchTotalCount(Connection conn, String searchKeyword, int clubNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM CLUB_POST WHERE CLUB_POST_SUBJECT = ? AND CLUB_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchKeyword);
			pstmt.setInt(2, clubNo);
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

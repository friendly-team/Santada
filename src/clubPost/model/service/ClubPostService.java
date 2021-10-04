package clubPost.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import club.model.dao.ClubDAO;
import clubPost.model.dao.clubPostDAO;
import clubPost.model.vo.ClubPost;
import clubPost.model.vo.ClubPostFile;
import clubPost.model.vo.ClubPostReply;
import clubPost.model.vo.PageData;
import common.JDBCTemplate;

public class ClubPostService {
private JDBCTemplate jdbcTemplate;
	
	public ClubPostService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}

	public int writeClubPost(ClubPost cPost) {
		Connection conn = null;
		clubPostDAO cDao = new clubPostDAO();
		int result = 0;
		int result2 = 0;
		int clubNo = 0;
		int postNo = 0;
		int sum = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			clubNo = cDao.selectClubNoById(conn, cPost.getUserId());
			result = cDao.createPost(conn, cPost, clubNo);
			postNo = cDao.selectPostNo(conn,cPost);
			if(cPost.getClubPostFile() != null) {
				result2 = cDao.insertImg(conn, cPost.getClubPostFile(),clubNo,postNo);
				sum = result + result2;
				if(sum > 1) {
					JDBCTemplate.commit(conn);
				}else {
					JDBCTemplate.rollback(conn);
				}
			}else {
				sum = result;
				if(sum > 0) {
					JDBCTemplate.commit(conn);
				}else {
					JDBCTemplate.rollback(conn);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return sum;
	}

	public PageData printAllClubPost(int currentPage, String userId) {
		PageData pd = new PageData();
		Connection conn = null;
		clubPostDAO cPDao = new clubPostDAO();
		int clubNo = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			clubNo = cPDao.selectClubNoById(conn, userId);
			pd.setClubPostList(cPDao.printAllClubPost(conn, currentPage, clubNo));
			pd.setPageNavi(cPDao.getPageNavi(conn, currentPage, clubNo));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}

	public ClubPost printDetailClubPost(int postNo) {
		ClubPost cpOne = null;
		Connection conn = null;
		List<ClubPostReply> list = null;
		clubPostDAO cDao = new clubPostDAO();
		String fileName = null;
		ClubPostFile cpFile = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			cpOne = cDao.printDetailClubPost(conn, postNo);
			
			list = cDao.selectAllPostReply(conn, postNo);
			cpOne.setClubReplies(list);
			
			fileName = cDao.selectPostFile(conn, postNo);
			if(fileName != null) {
				cpFile = new ClubPostFile();
				cpFile.setFileName(fileName);
				cpOne.setClubPostFile(cpFile);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return cpOne;
	}

	public int removeClubPost(int postNo, int clubNo, String userId, String writeUser) {
		Connection conn = null;
		int result = 0;
		int result2 = 0;
		int sum = 0;
		String masterId = null;
		String fileName = null;
		clubPostDAO cpDao = new clubPostDAO();
		try {
			conn = jdbcTemplate.createConnection();
			masterId = new ClubDAO().selectMasterId(conn, clubNo);
			if((userId.equals(writeUser)) || masterId.equals(userId)) {
				result = cpDao.deleteClubPost(conn, postNo);
				fileName = cpDao.selectPostFile(conn, postNo);
				if(fileName != null) {
					result2 = cpDao.deleteClubFile(conn, fileName);
					sum = result + result2;
					if(sum > 1) {
						JDBCTemplate.commit(conn);
					}else {
						JDBCTemplate.rollback(conn);
					}
				}else {
					sum = result;
					if(sum>0) {
						JDBCTemplate.commit(conn);
					}else {
						JDBCTemplate.rollback(conn);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return sum;
	}

	public int modifyClubPost(ClubPost cp) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new clubPostDAO().updateClubPost(conn, cp);
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

	public int registerClubPostReeply(ClubPostReply cpReply) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new clubPostDAO().insertClubPostReply(conn, cpReply);
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

	public int deleteClubPostReply(String userId, int postNo, int replyNo, String writeUser) {
		Connection conn = null;
		int result = 0;
		if(writeUser.equals(userId)) {
			try {
				conn = jdbcTemplate.createConnection();
				result = new clubPostDAO().deleteClubPostReply(conn, replyNo);
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
		}
		return result;
	}

	public int modifyClubPostReply(String userId, int replyNo, String replyContents, int postNo, String replyUser) {
		Connection conn = null;
		int result = 0;
		if(replyUser.equals(userId)) {
			try {
				conn = jdbcTemplate.createConnection();
				result = new clubPostDAO().updateClubPostReply(conn, replyNo, replyContents, postNo);
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
		}
		return result;
	}

	public int recommendClubPost(int postNo, int recommend) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new clubPostDAO().recommendClubPost(conn, postNo, recommend);
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

	public PageData printSearchClubPost(String searchKeyword, int clubNo, int currentPage) {
		Connection conn = null;
		List<ClubPost> cpList = null;
		String searchPageNavi = null;
		PageData pd = new PageData();
		clubPostDAO cpDao = new clubPostDAO();
		
		try {
			conn = jdbcTemplate.createConnection();
			cpList = cpDao.printSearchClubPost(conn, searchKeyword, clubNo,currentPage);
			searchPageNavi = cpDao.getSearchPageNavi(conn, searchKeyword, currentPage, clubNo);
			pd.setClubPostList(cpList);
			pd.setPageNavi(searchPageNavi);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}


}

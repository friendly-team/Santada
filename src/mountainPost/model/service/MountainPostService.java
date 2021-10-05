package mountainPost.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import mountainPost.model.dao.MountainPostDAO;
import mountainPost.model.vo.MountainPost;
import mountainPost.model.vo.MountainPostReply;
import mountainPost.model.vo.MtFileData;
import mountainPost.model.vo.PageData;
import mountainPostFile.model.dao.MtFileDAO;

public class MountainPostService {
	private JDBCTemplate jdbcTemplate;

	public MountainPostService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}

	public int registerMountainPost(MountainPost mPost, MtFileData fileData) {
		int result = 0;
		int fResult = 0;
		int mPostNo = 0;
		int sum = 0;
		Connection conn = null;
		MountainPostDAO mDAO = new MountainPostDAO();
		MtFileDAO fDAO = new MtFileDAO();
		try {
			conn = jdbcTemplate.createConnection();
			result = mDAO.insertMountainPost(conn, mPost);
			mPostNo = mDAO.selectPostNo(conn, mPost);
			fResult = fDAO.insertFileInfo(conn, mPostNo, fileData);
			sum = result + fResult;
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			if(fResult > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return sum;
	}

	public PageData printAllmPost(int currentPage) {
		PageData pd = new PageData();
		Connection conn = null;
		MountainPostDAO mDAO = new MountainPostDAO();
		try {
			conn = jdbcTemplate.createConnection();
			pd.setmList(mDAO.selectAllmPost(conn, currentPage));
			pd.setPageNavi(mDAO.getPageNavi(conn, currentPage));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}

	public MountainPost printOneByNo(int mtPostNo) {
		MountainPost mPostOne = null;
		List<MountainPostReply> rList = null;
		Connection conn = null;
		MountainPostDAO mDAO = new MountainPostDAO();
		try {
			conn = jdbcTemplate.createConnection();
			mPostOne = mDAO.selectOneByNo(conn, mtPostNo);
			rList = mDAO.selectAllMountainPostReply(conn, mtPostNo);
			mPostOne.setReplies(rList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return mPostOne;
	}

	public int removeMountainPost(int mPostNo) {
		int result = 0;
		int fResult = 0;
		int sum = 0;
		Connection conn = null;
		MountainPostDAO mDAO = new MountainPostDAO();
		MtFileDAO fDAO = new MtFileDAO();
		try {
			conn = jdbcTemplate.createConnection();
			result = mDAO.deleteMountainPost(conn, mPostNo);
			fResult = fDAO.deleteMountainPostFile(conn, mPostNo);
			sum = result + fResult;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return sum;
	}

	public int modifyMountainPost(MountainPost mPost) {
		int result = 0;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			result = new MountainPostDAO().updateMountainPost(conn, mPost);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public PageData printSearchMountainPost(String searchKeyword, int currentPage) {
		PageData pd = new PageData();
		List<MountainPost> mList = null;
		Connection conn = null;
		String searchPageNavi = null;
		MountainPostDAO mDAO = new MountainPostDAO();
		try {
			conn = jdbcTemplate.createConnection();
			mList = mDAO.selectSearchMountainPost(conn, searchKeyword, currentPage);
			searchPageNavi = mDAO.getSearchPageNavi(conn, searchKeyword, currentPage);
			pd.setmList(mList);
			pd.setPageNavi(searchPageNavi);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}

	public int registerMountainPostReply(String userId, int mPostNo, String replyContents) {
		int result = 0;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			result = new MountainPostDAO().insertMountainPostReply(conn, userId, mPostNo, replyContents);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int removeMountianPostReplyOne(int replyNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			result = new MountainPostDAO().deleteMountainPostReply(conn, replyNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int modifyReplyOne(String replyContents, int replyNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			result = new MountainPostDAO().updateReplyOne(conn, replyContents, replyNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int plusMountainRecommend(int mPostNo, int recCount) {
		int result = 0;
		Connection conn = null;;
		try {
			conn = jdbcTemplate.createConnection();
			result = new MountainPostDAO().updateMountainRecommend(conn, mPostNo, recCount);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	// mainServlet 
	public List<MountainPost> printPostAll() {
		Connection conn = null;
		List<MountainPost> mList = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			mList = new MountainPostDAO().selectAllList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		
		return mList;
	}

	// mainDetailServlet 
	public MountainPost printMainPost(int mountainPostNo) {
		MountainPost mPost = null;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			mPost = new MountainPostDAO().selectMountainPost(conn, mountainPostNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return mPost;
	}
	
}

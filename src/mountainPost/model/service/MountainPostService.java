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
		MountainPost mOne = null;
//		List<MountainPostReply> list = null;
		Connection conn = null;
		MountainPostDAO mDAO = new MountainPostDAO();
		try {
			conn = jdbcTemplate.createConnection();
			mOne = mDAO.selectOneByNo(conn, mtPostNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return mOne;
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
	
}

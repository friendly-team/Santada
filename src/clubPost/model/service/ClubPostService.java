package clubPost.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
		}
		return cpOne;
	}

}

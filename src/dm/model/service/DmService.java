package dm.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import dm.model.dao.DmDAO;
import dm.model.vo.Dm;
import dm.model.vo.PageData;




public class DmService {

private JDBCTemplate jdbcTemplate;
	
	public DmService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	};
	
	public int sendLetter(Dm dm) {
		int result = 0;

		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection(); 
			result = new DmDAO().insertDm(conn, dm);

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

	public PageData printAllLetter(int currentPage, String memberId) {
		PageData pd = new PageData();
		Connection conn = null;
		DmDAO nDAO = new DmDAO();
		try {
			conn = jdbcTemplate.createConnection();
			List<Dm> nList = nDAO.selectAllLetter(conn, currentPage, memberId);
			String pageNavi = nDAO.getPageNavi(conn, currentPage, memberId);
			pd.setletterList(nList);
			pd.setPageNavi(pageNavi); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}

	public Dm printOneByNo(int letterNo) {
		Dm LetterOne = null;
		Connection conn = null;
		DmDAO nDao = new DmDAO();
		try {
			conn = jdbcTemplate.createConnection();
			LetterOne = new DmDAO().selectOneByNo(conn, letterNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return LetterOne;
	}

	public PageData printBoxLetter(int currentPage, String memberId) {
		PageData pd = new PageData();
		Connection conn = null;
		DmDAO nDAO = new DmDAO();
		try {
			conn = jdbcTemplate.createConnection();
			List<Dm> bList = nDAO.selectBoxLetter(conn, currentPage, memberId);
			String pageNavi = nDAO.getPageNaviG(conn, currentPage, memberId);
			pd.setletterList(bList);
			pd.setPageNavi(pageNavi); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}

	public int removeLetterOne(int letterNo) {
		Connection conn = null;
		int result = 0;
		try {
			conn = jdbcTemplate.createConnection();
			result = new DmDAO().deleteLetterOne(conn, letterNo);
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


	
}

package treeCampaign.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.Member;
import treeCampaign.model.dao.TreeCampaignDAO;
import treeCampaign.model.vo.TreeCampaign;

public class TreeCampaignService {
	private JDBCTemplate jdbcTemplate;
	
	public TreeCampaignService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}

	public int registerTreeCampaign(TreeCampaign tCampaign, Member member, int treePoint) {
		int sum = 0;
		int result = 0;
		Connection conn = null;
		TreeCampaignDAO tDAO = new TreeCampaignDAO();
		try {
			conn = jdbcTemplate.createConnection();
			result = tDAO.insertTreeCampaign(conn, tCampaign);
			sum = result + treePoint;
			if(result > 0 && treePoint > 500) {
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

	public Member printMember(String userId) {
		Member member = null;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			member = new TreeCampaignDAO().selectMember(conn, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return member;
	}

	public List<TreeCampaign> printPointList() {
		Connection conn = null;
		List<TreeCampaign> tList = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			tList = new TreeCampaignDAO().selectPointList(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return tList;
		}

	public int removePoint(String userId) {
		int result = 0;
		int treePoint = 0;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			treePoint = new TreeCampaignDAO().selectTreePoint(conn, userId);
			result = new TreeCampaignDAO().removePoint(conn, userId, treePoint);
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

	



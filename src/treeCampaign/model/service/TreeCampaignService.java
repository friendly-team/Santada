package treeCampaign.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.JDBCTemplate;
import member.model.vo.Member;
import treeCampaign.model.dao.TreeCampaignDAO;
import treeCampaign.model.vo.TreeCampaign;

public class TreeCampaignService {
	private JDBCTemplate jdbctemplate;
	
	public TreeCampaignService() {
		jdbctemplate = JDBCTemplate.getConnection();
	}

	public int registerTreeCampaign(TreeCampaign tCampaign, Member user) {
		int sum = 0;
		int result = 0;
		int treePoint = 0;
		Connection conn = null;
		TreeCampaignDAO tDAO = new TreeCampaignDAO();
		try {
			conn = jdbctemplate.createConnection();
			result = tDAO.insertTreeCampaign(conn, tCampaign);
			treePoint = tDAO.selectTreePoint(conn, user);
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

}

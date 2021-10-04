package treeCampaign.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import member.model.vo.Member;
import treeCampaign.model.vo.TreeCampaign;

public class TreeCampaignDAO {

	public int insertTreeCampaign(Connection conn, TreeCampaign tCampaign) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO TREE_CAMPAIGN VALUES(SEQ_TREE_POST.NEXTVAL,?,?,?,DEFAULT)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, tCampaign.getTreeUserId());
			pstmt.setString(2, tCampaign.getTreeParticipant());
			pstmt.setString(3, tCampaign.getTreeContents());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int selectTreePoint(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT USER_ID, TREE_POINT FROM MEMBER WHERE USER_ID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				member.setUserId(rset.getString("USER_ID"));
				member.setTreePoint(rset.getInt("TREE_POINT"));
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

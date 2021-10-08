package treeCampaign.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	public Member selectMember(Connection conn, String userId) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT USER_ID, TREE_POINT FROM MEMBER WHERE USER_ID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			member = new Member();
			rset = pstmt.executeQuery();
			if(rset.next()) {
				member.setTreePoint(rset.getInt("TREE_POINT"));
				member.setUserId(rset.getString("USER_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return member;
	}

	public List<TreeCampaign> selectPointList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		List<TreeCampaign> tList = null;
		String query = "SELECT * FROM TREE_CAMPAIGN";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			tList = new ArrayList<TreeCampaign>();
			while(rset.next()) {
				TreeCampaign tCampaign = new TreeCampaign();
				tCampaign.setTreePostNo(rset.getInt("TREE_POST_NO"));
				tCampaign.setTreeUserId(rset.getString("USER_ID"));
				tCampaign.setTreeParticipant(rset.getString("TREE_PARTICIPANT"));
				tCampaign.setTreeContents(rset.getString("TREE_CONTENTS"));
				tCampaign.setTreeDate(rset.getDate("TREE_DATE"));
				// 최종적으로 저장
				tList.add(tCampaign);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return tList;
	}

	public int removePoint(Connection conn, String userId, int treePoint) {
		PreparedStatement pstmt = null;
		int result = 0;
		int sum = treePoint - 500;
		String query = "UPDATE MEMBER SET TREE_POINT = ? WHERE USER_ID = ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sum);
			pstmt.setString(2, userId);
			// 쿼리문 실행 ???
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int selectTreePoint(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		int treePoint = 0;
		ResultSet rset = null;
		String query = "SELECT * FROM MEMBER WHERE USER_ID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			// 쿼리문 실행 ???
			rset = pstmt.executeQuery();
			if(rset.next()) {
				treePoint = rset.getInt("TREE_POINT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return treePoint;
	}


}




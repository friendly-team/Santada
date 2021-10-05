package rankning.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import member.model.vo.Member;

public class RankingDAO {

	public List<Member> selectRanking(Connection conn) {
		List<Member> mList = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT ROWNUM, USER_ID, NORMAL_POINT FROM (SELECT USER_ID, NORMAL_POINT FROM MEMBER ORDER BY NORMAL_POINT DESC) WHERE ROWNUM < 51";
		try {
			stmt = conn.createStatement();
			mList = new ArrayList<Member>();
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				Member member = new Member();
				member.setUserId(rset.getString("USER_ID"));
				member.setNormalPoint(rset.getInt("NORMAL_POINT"));
				mList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return mList;
	}

}

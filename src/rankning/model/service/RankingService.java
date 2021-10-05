package rankning.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import member.model.vo.Member;
import rankning.model.dao.RankingDAO;

public class RankingService {
	private JDBCTemplate jdbcTemplate;
	
	public RankingService () {
		jdbcTemplate = JDBCTemplate.getConnection();
	}

	public List<Member> printRanking() {
		List<Member> mList = null;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			mList = new RankingDAO().selectRanking(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return mList;
	}

}

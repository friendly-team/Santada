package parking.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.JDBCTemplate;
import parking.model.dao.ParkinglotInfoDAO;
import parking.model.vo.ParkinglotInfo;

public class ParkinglotInfoService {



	private JDBCTemplate jdbcTemplate;

	public ParkinglotInfoService() {
		jdbcTemplate = JDBCTemplate.getConnection();
		
	}

	public ParkinglotInfo Detail(String parkinglotNo) {
		ParkinglotInfo pInfo = null;
		Connection conn = null;

		try {
			conn = jdbcTemplate.createConnection();
			pInfo = new ParkinglotInfoDAO().selectDetail(conn, parkinglotNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pInfo;
	}
}




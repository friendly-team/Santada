package parkingReservation.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import parkingReservation.model.dao.ParkingReservationDAO;
import parkingReservation.model.vo.ParkingReservation;

public class ParkingReservationService {

	private JDBCTemplate jdbcTemplate;
	
	public ParkingReservationService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	};
	
	public List<ParkingReservation> printOneById(String memberId) {
		List<ParkingReservation> pList = null;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			pList = new ParkingReservationDAO().selectOneById(conn, memberId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);	
		}
		return pList;

	}
}

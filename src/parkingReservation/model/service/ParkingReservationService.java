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
	}
	
	//예약등록
	public int registerParkingReservation(ParkingReservation pReservation) {
		int result = 0;
		Connection conn = null;
		ParkingReservationDAO pDAO = new ParkingReservationDAO();
		try {
			conn = jdbcTemplate.createConnection();
			result = pDAO.insertParkingReservation(conn,pReservation);
			if (result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
     }

	//예약 내역
	public PageData printAllparkinglotReservation(int currentPage) {
		PageData pd = new PageData();
		Connection conn = null;
		ParkingReservationDAO pDAO = new ParkingReservationDAO();
		try {
			conn = jdbcTemplate.createConnection();
			pd.setpReList(pDAO.selectAllParkingReservation(conn,currentPage));
			pd.setPageNavi(pDAO.getPageNavi(conn, currentPage));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}

	
	//예약 내역 조회
	public ParkingReservation printOneByNo(int reservationNo) {
		ParkingReservation pReOne = null;
	};
	
	public List<ParkingReservation> printOneById(String memberId) {
		List<ParkingReservation> pList = null;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			pReOne = new ParkingReservationDAO().selectOneByNO(conn,reservationNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pReOne ;
	}

	
	//예약 내역 조회 후  삭제 (예약 취소)
	public int modifyParkingReservation(ParkingReservation parkingreservation) {
		int result = 0;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			result = new ParkingReservationDAO().updateNotice(conn,parkingreservation);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
		
	}
		public List<ParkingReservation> printOneId(String memberId) {
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

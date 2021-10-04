package parkingReservation.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import parkingReservation.model.vo.ParkingReservation;

public class ParkingReservationDAO {

	public List<ParkingReservation> selectOneById(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<ParkingReservation> pList = null;
		String query = "SELECT * FROM PARKINGLOT_RESERVATIONNT WHERE USER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			pList = new ArrayList<ParkingReservation>();
			while(rset.next()) {
				ParkingReservation parking = new ParkingReservation();
				parking = new ParkingReservation();
				parking.setReservationNo(rset.getInt("RESERVATION_NO"));
				parking.setUserId(rset.getString("USER_ID"));
				parking.setMountainName(rset.getString("MOUNTAIN_NAME"));
				parking.setReservationStartTime(rset.getString("RESERVATION_START_TIME"));
				parking.setReservationEndTime(rset.getString("RESERVATION_END_TIME"));
				parking.setReservationCarType(rset.getString("RESERVATION_CAR_TYPE"));
				parking.setReservationPayTpye(rset.getString("RESERVATION_PAY_TYPE"));
				parking.setReservationPayTotalPrice(rset.getInt("RESERVATION_PAY_TOTAL_PRICE"));
				parking.setReservationCancel(rset.getString("RESERVATION_CANCEL_YN"));
				parking.setReservationStartDate(rset.getString("RESERVATION_START_DATE"));
				parking.setReservationEndDate(rset.getString("RESERVATION_END_DATE"));
				pList.add(parking);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return pList;
		
	}

}

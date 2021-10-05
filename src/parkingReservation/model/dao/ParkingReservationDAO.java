package parkingReservation.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import parkingReservation.model.vo.ParkingReservation;

public class ParkingReservationDAO {
	//주차장 예약
	public int insertParkingReservation(Connection conn, ParkingReservation pReservation) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query  = "INSERT INTO PARKINGLOTINFO VALUES(?,?,?,?,?,?,?,?,?,DEFAULT)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pReservation.getReservationNo());
			pstmt.setString(2, pReservation.getUserId());
			pstmt.setString(3, pReservation.getMountainName());
			pstmt.setString(4, pReservation.getReservationStartTime());
			pstmt.setString(5, pReservation.getReservationEndTime());
			pstmt.setString(6, pReservation.getReservationCarType());
			pstmt.setString(7, pReservation.getReservationPayTpye());
			pstmt.setString(8, pReservation.getReservationStartDate());
			pstmt.setString(9, pReservation.getReservationEndDate());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	
	//주차장 예약내역
	public List<ParkingReservation> selectAllParkingReservation(Connection conn, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM PARKINGRESERVATION";
		List<ParkingReservation> pList = null;
		try {
			pstmt = conn.prepareStatement(query);
			int viewCountPerPage = 10;
			int start = currentPage * viewCountPerPage - (viewCountPerPage -1);
			int end = currentPage * viewCountPerPage;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			pList = new ArrayList<ParkingReservation>();
			while(rset.next()) {
				ParkingReservation parkingreservation = new ParkingReservation();
				parkingreservation.setReservationNo(rset.getInt("reservationNo"));
				parkingreservation.setUserId(rset.getString("userId"));
				parkingreservation.setMountainName(rset.getString("mountainName"));
				parkingreservation.setReservationCarType(rset.getString("reservationCarType"));
				parkingreservation.setReservationStartDate(rset.getString("reservationStartDate"));
				parkingreservation.setReservationEndDate(rset.getString("reservationEndDate"));
				parkingreservation.setReservationStartTime(rset.getString("reservationStartTime"));
				parkingreservation.setReservationEndTime(rset.getString("reservationEndTime"));
				parkingreservation.setReservationPayTpye(rset.getString("reservationPayTpye"));
				parkingreservation.setReservationPayTotalPrice(rset.getInt("reservationPayTotalPrice"));
			}
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return pList;
	}

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
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return pList;
	}
	
	
	//페이징 처리
	public String getPageNavi(Connection conn, int currentPage) {
		
		int pageCountPerView = 5;
		int viewTotalCount = totalCount(conn);
		int viewCountPerPage = 10;
		int pageTotalCount = 0;
		int pageTotalCountMod = viewTotalCount % viewCountPerPage;
		if(pageTotalCountMod > 0) {
			pageTotalCount = viewTotalCount / viewCountPerPage + 1;
		}else {
			pageTotalCount = viewTotalCount / viewCountPerPage;
		}
		int startNavi = ((currentPage - 1) / pageCountPerView) * pageCountPerView + 1;
		int endNavi = startNavi + pageCountPerView - 1;
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/parkingReservation/list?currentPage=" 
					+ (startNavi-1) + "'> [이전] </a>");
		}
		for(int i=startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append(i + " ");
			}else {
				sb.append("<a href='/parkingReservation/list?currentPage=" + i +"'>" + i + " </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/parkingReservation/list?currentPage=" 
					+ (endNavi+1) + "'> [다음] </a>");
		}
		return sb.toString();
	}
	
	public int totalCount(Connection conn) {
		int totalValue = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				totalValue = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return totalValue;
	}
	
	
	//주차장예약 하나의 내역
	public ParkingReservation selectOneByNO(Connection conn, int reservationNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ParkingReservation pReOne = null;
		String query = "SELECT * FROM PARKINGRESERVATION WHERE RESERVATIONNO = ?";
		
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1,reservationNo);
				rset = pstmt.executeQuery();
				if(rset.next ()) {
					pReOne = new ParkingReservation();
					pReOne.setReservationNo(rset.getInt("reservationNo"));
					pReOne.setUserId(rset.getString("userId"));
					pReOne.setMountainName(rset.getString("mountainName"));
					pReOne.setReservationCarType(rset.getString("reservationCarType"));
					pReOne.setReservationStartDate(rset.getString("reservationStartDate"));
					pReOne.setReservationEndDate(rset.getString("reservationEndDate"));
					pReOne.setReservationStartTime(rset.getString("reservationStartTime"));
					pReOne.setReservationEndTime(rset.getString("reservationEndTime"));
					pReOne.setReservationCancel(rset.getString("reservationCancel"));
				}	
			} catch (SQLException e) {
			
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return pReOne;
	}

	//주차장 예약 취소
	public int updateNotice(Connection conn, ParkingReservation parkingreservation) {
		PreparedStatement pstmt = null;
		String query = "UPDATE NOTICE SET RESERVATION_CANCEL_YN = ?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, parkingreservation.getReservationNo());
//			pstmt.setString(2, parkingreservation.getUserId());
//			pstmt.setString(3,parkingreservation.getMountainName());
//			pstmt.setString(4,parkingreservation.getReservationCarType());
//			pstmt.setString(5,parkingreservation.getReservationStartDate());
//			pstmt.setString(6,parkingreservation.getReservationEndDate());
//			pstmt.setString(7,parkingreservation.getReservationStartTime());
//			pstmt.setString(8,parkingreservation.getReservationEndTime());
			pstmt.setString(9,parkingreservation.getReservationCancel());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return pList;
	}

}

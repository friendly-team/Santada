<<<<<<< Updated upstream
package parking.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import parking.model.vo.ParkinglotInfo;

public class ParkinglotInfoDAO {




	public ParkinglotInfo selectDetail(Connection conn, String parkinglotNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ParkinglotInfo pInfo = null;
		String query = "SELECT * FROM MOUNTAIN_PARKINGLOT_INFO WHERE PARKINGLOT_NO = ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, parkinglotNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				pInfo = new ParkinglotInfo();
				pInfo.setParkinglotNo(rset.getInt("PARKINGLOT_NO"));
				pInfo.setMountainName(rset.getString("MOUNTAIN_NAME"));
				pInfo.setParkinglotName(rset.getString("PARKINGLOT_NAME"));
				pInfo.setParkinglotAddress(rset.getString("PARKINGLOT_ADDRESS"));
				pInfo.setParkinglotTel(rset.getString("PARKINGLOT_TEL"));
				pInfo.setParkinglotOpenTime(rset.getString("PARKINGLOT_OPEN_TIME"));
				pInfo.setParkinglotCloseTime(rset.getString("PARKINGLOT_CLOSE_TIME"));
				pInfo.setParkinglotPriceBig(rset.getInt("PARKINGLOT_PRICE_BIG"));
				pInfo.setParkinglotPriceSmall(rset.getInt("PARKINGLOT_PRICE_SMALL"));
				pInfo.setParkinglotDayPriceBig(rset.getInt("PARKINGLOT_DAY_PRICE_BIG"));
				pInfo.setParkinglotDayPriceSmall(rset.getInt("PARKINGLOT_DAY_PRICE_SMALL"));
				pInfo.setParkinglotGoogleMapX(rset.getInt("PARKINGLOT_GOOLE_MAP_X"));
				pInfo.setParkinglotGoogleMapY(rset.getInt("PARKINGLOT_GOOLE_MAP_Y"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return pInfo;
	}
}
=======
package parking.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import parking.model.vo.ParkinglotInfo;

public class ParkinglotInfoDAO {




	public ParkinglotInfo selectDetail(Connection conn, String parkinglotNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ParkinglotInfo pInfo = null;
		String query = "SELECT * FROM MOUNTAIN_PARKINGLOT_INFO WHERE PARKINGLOT_NO = ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, parkinglotNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				pInfo = new ParkinglotInfo();
				pInfo.setParkinglotNo(rset.getInt("PARKINGLOT_NO"));
				pInfo.setMountainName(rset.getString("MOUNTAIN_NAME"));
				pInfo.setParkinglotName(rset.getString("PARKINGLOT_NAME"));
				pInfo.setParkinglotAddress(rset.getString("PARKINGLOT_ADDRESS"));
				pInfo.setParkinglotTel(rset.getString("PARKINGLOT_TEL"));
				pInfo.setParkinglotOpenTime(rset.getString("PARKINGLOT_OPEN_TIME"));
				pInfo.setParkinglotCloseTime(rset.getString("PARKINGLOT_CLOSE_TIME"));
				pInfo.setParkinglotPriceBig(rset.getString("PARKINGLOT_PRICE_BIG"));
				pInfo.setParkinglotPriceSmall(rset.getString("PARKINGLOT_PRICE_SMALL"));
				pInfo.setParkinglotDayPriceBig(rset.getString("PARKINGLOT_DAY_PRICE_BIG"));
				pInfo.setParkinglotDayPriceSmall(rset.getString("PARKINGLOT_DAY_PRICE_SMALL"));
				pInfo.setParkinglotGoogleMapX(rset.getString("PARKINGLOT_GOOLE_MAP_X"));
				pInfo.setParkinglotGoogleMapY(rset.getString("PARKINGLOT_GOOLE_MAP_Y"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return pInfo;
	}
}
>>>>>>> Stashed changes

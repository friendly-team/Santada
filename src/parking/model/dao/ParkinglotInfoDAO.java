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
		String query = "SELECT * FROM PARKINGLOT_INFO WHERE PARKINGLOT_NO = ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, parkinglotNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				pInfo = new ParkinglotInfo();
				pInfo.setParkinglot_no(rset.getInt("parkinglot_no"));
				pInfo.setMountain_name(rset.getString("mountain_name"));
				pInfo.setParkinglot_name(rset.getString("parkinglot_name"));
				pInfo.setParkinglot_address(rset.getString("parkinglot_address"));
				pInfo.setParkinglot_tel(rset.getString("parkinglot_tel"));
				pInfo.setParkinglot_open_time(rset.getString("parkinglot_open_time"));
				pInfo.setParkinglot_close_time(rset.getString("parkinglot_close_time"));
				pInfo.setParkinglot_price_big(rset.getInt("parkinglot_price_big"));
				pInfo.setParkinglot_price_small(rset.getInt("parkinglot_price_small"));
				pInfo.setParkinglot_dayprice_big(rset.getInt("parkinglot_dayprice_big"));
				pInfo.setParkinglot_dayprice_small(rset.getInt("parkinglot_dayprice_small"));
				pInfo.setParkinglot_google_map_x(rset.getInt("parkinglot_google_map_x"));
				pInfo.setParkinglot_google_map_y(rset.getInt("parkinglot_google_map_y"));
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

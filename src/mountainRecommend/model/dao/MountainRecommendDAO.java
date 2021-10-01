package mountainRecommend.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import mountainPost.model.vo.MountainPost;
import mountainRecommend.model.vo.Mountain;
import mountainRecommend.model.vo.MountainRecommend;

public class MountainRecommendDAO {


	// 셀렉트에서 고른 값과 같은 것을 디비에서 불러와서 출력하는 쿼리문 
	public List<MountainPost> printMountainPost(Connection conn, String MountainRegion, int MountainTime, int MountainLevel) {
		List<MountainPost> pList = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MOUNTAIN_POST WHERE MOUNTAIN_REGION = ?, MOUNTAIN_TIME = ?, MOUNTAIN_LEVEL = ?  ODER BY MOUNTAIN_RECOMMEND DESC";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, MountainRegion);
			pstmt.setInt(2, MountainTime);
			pstmt.setInt(3, MountainLevel);
			pList = new ArrayList<MountainPost>();
			rset = pstmt.executeQuery(); // => 쿼리문 실행
			while(rset.next()) {
				MountainRecommend mRecommend = new MountainRecommend(); // => 객체생성
				mRecommend.setMountainName(rset.getString("MOUNTAIN_NAME"));
				mRecommend.setMountainTime(rset.getInt("MOUNTAIN_TIME"));
				mRecommend.setMountainParty(rset.getInt("MOUNTAIN_PARTY"));
				mRecommend.setMountainCourse(rset.getString("MOUNTAIN_COURSE"));
				mRecommend.setMountainPostNo(rset.getInt("MOUNTAIN_POST_NO"));
				mRecommend.setParkingLotNo(rset.getInt("PARKING")); // -> 추후 변수명 변경 가능성 있음			
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return pList;
	}

	public List<Mountain> printMountain(Connection conn, String MountainCouse) {
		// TODO Auto-generated method stub
		List<Mountain> mList = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MOUNTAIN WHERE MOUNTAIN_COURSE = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, MountainCouse);
			mList = new ArrayList<Mountain>();
			rset = pstmt.executeQuery(); // => 쿼리문 실행 
			while(rset.next()) {
				Mountain mountain = new Mountain(); // => 객체생성 
				mountain.setMountainLength("MOUNTAIN_LENGTH");
				mountain.setParkingLotNo(rset.getInt("PARKING")); // -> 추후 변수명 변경 가능성 있음				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return mList;
	}
	


}

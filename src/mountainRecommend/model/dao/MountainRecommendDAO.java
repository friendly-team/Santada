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
	public List<Mountain> printMountain(Connection conn, String mountainRegion) {
		List<Mountain> mList = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MOUNTAIN WHERE MOUNTAIN_REGION = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mountainRegion);
			mList = new ArrayList<Mountain>();
			rset = pstmt.executeQuery(); // => 쿼리문 실행
			while(rset.next()) {
				Mountain mountain = new Mountain(); // => 객체생성
				mountain.setMountainName(rset.getString("MOUNTAIN_NAME"));
				mountain.setMountainCourse(rset.getString("MOUNTAIN_COURSE"));
				mountain.setMountainLength(rset.getString("MOUNTAIN_LENGTH"));
				mountain.setMountainRegion(rset.getString("MOUNTAIN_REGION"));
				mountain.setParkingLotNo(rset.getInt("PARKINGLOT_NO"));
				mList.add(mountain);
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
	
	public int printRandomNumber(Connection conn, String mountainRegion) {
		int totalValue = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM MOUNTAIN WHERE MOUNTAIN_REGION = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mountainRegion);
			rset = pstmt.executeQuery(); // => 쿼리문 실행
			if(rset.next()) {
				totalValue = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return totalValue;
	}

	public List<MountainPost> printMountainPost(Connection conn, String	mountainCourse, String mountainRegion, int mountainTime, int mountainLevel) {
		// TODO Auto-generated method stub
		List<MountainPost> pList = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MOUNTAIN_POST WHERE MOUNTAIN_COURSE = ? AND MOUNTAIN_REGION = ? AND MOUNTAIN_TIME = ? AND MOUNTAIN_LEVEL = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mountainCourse);
			pstmt.setString(2, mountainRegion);
			pstmt.setInt(3, mountainTime);
			pstmt.setInt(4, mountainLevel);
			pList = new ArrayList<MountainPost>();
			rset = pstmt.executeQuery(); // => 쿼리문 실행 
			while(rset.next()) {
				MountainPost mRecommend = new MountainPost(); // => 객체생성 
				mRecommend.setMountainName(rset.getString("MOUNTAIN_NAME"));
				mRecommend.setMountainParty(rset.getInt("MOUNTAIN_PARTY"));
				mRecommend.setMountainTime(rset.getInt("MOUNTAIN_TIME")); // -> 추후 변수명 변경 가능성 있음	
				mRecommend.setMountainCourse(rset.getString("MOUNTAIN_COURSE"));
				mRecommend.setMountainRegion(rset.getString("MOUNTAIN_REGION"));
				mRecommend.setMountainPostNo(rset.getInt("MOUNTAIN_POST_NO"));
				mRecommend.setMountainPostSubject(rset.getString("MOUNTAIN_POST_SUBJECT"));
				mRecommend.setMountainLevel(rset.getInt("MOUNTAIN_LEVEL"));	
				pList.add(mRecommend); // -> 저장
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


	


}

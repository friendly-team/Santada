package mountainRecommend.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import mountainPost.model.vo.MountainPost;
import mountainRecommend.model.dao.MountainRecommendDAO;
import mountainRecommend.model.vo.Mountain;
import mountainRecommend.model.vo.MountainRecommend;

public class MountainRecommendService {
	
	private JDBCTemplate jdbcTemplate;
	
	public MountainRecommendService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}

	// 원하는 기능
	// 셀렉트 박스에서 선택한 값 중에 MOUNTAIN_POST에서 저장된 것과 일치하는 POST 정보를 불러오게 하기
	// 1. MOUNTAIN_RECOMMEND에서 선택한 값을 보내준다. => service (세개의 값을 리스트로 보내주기)
	// 2. 보내 준 값을  MOUNTAIN_POST에서 가져오게 한다. => DAO (세개의 값이랑 일치하는 것을 post에서 찾아주는 쿼리문)
	// 3. JSP에 항목별로 ${}를 이용해서 출력 시킨다. 
	public List<Mountain> printMountain(String mountainRegion) {
		List<Mountain> mList = null; 
		Connection conn = null;
		
		try {
		conn = jdbcTemplate.createConnection();
		mList = new MountainRecommendDAO().printMountain(conn, mountainRegion);
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn); // DB연결 해제
		}
		return mList;
	}
	
	public List<MountainPost> selectMountainPost(String mountainCourse, String mountainRegion, int mountainTime, int mountainLevel) {
		List<MountainPost> pList = null; 
		Connection conn = null;
		
		try {
		conn = jdbcTemplate.createConnection();
		pList = new MountainRecommendDAO().printMountainPost(conn, mountainCourse, mountainRegion, mountainTime, mountainLevel);
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn); // DB연결 해제
		}
		return pList;
	}
	
	// 지역에서 코스를 받고 -> 코스 중 랜덤으로 하나를 골라냄
	public int getRandomNumber(String mountainRegion) {
		int count = 0;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			count = new MountainRecommendDAO().printRandomNumber(conn, mountainRegion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		
		return count;
	}


}

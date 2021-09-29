package mountainPostFile.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.JDBCTemplate;
import mountainPost.model.vo.MtFileData;
import mountainPostFile.model.dao.MtFileDAO;

public class MtFileService {
	private JDBCTemplate jdbcTemplate;

	public MtFileService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}

	public MtFileData printOneByNo(int mtPostNo) {
		MtFileData mFileOne = null;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			mFileOne = new MtFileDAO().selectOneByNo(conn, mtPostNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mFileOne;
	}
	
}

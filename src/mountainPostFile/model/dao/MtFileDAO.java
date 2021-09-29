package mountainPostFile.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import mountainPost.model.vo.MtFileData;

public class MtFileDAO {

	public int insertFileInfo(Connection conn, int mPostNo, MtFileData fileData) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO MOUNTAIN_POST_FILE VALUES(?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mPostNo);
			pstmt.setString(2, fileData.getMtName());
			pstmt.setString(3, fileData.getFileName());
			pstmt.setString(4, fileData.getFilePath());
			pstmt.setLong(5, fileData.getFileSize());
			pstmt.setString(6, fileData.getFileUser());
			pstmt.setTimestamp(7, fileData.getUploadTime());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteMountainPostFile(Connection conn, int mPostNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM MOUNTAIN_POST_FILE WHERE MOUNTAIN_POST_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mPostNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public MtFileData selectOneByNo(Connection conn, int mtPostNo) {
		MtFileData mFileOne = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MOUNTAIN_POST_FILE WHERE MOUNTAIN_POST_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mtPostNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				mFileOne = new MtFileData();
				mFileOne.setMtPostNo(rset.getInt("MOUNTAIN_POST_NO"));
				mFileOne.setMtName(rset.getString("MOUNTAIN_NAME"));
				mFileOne.setFileName(rset.getString("FILE_NAME"));
				mFileOne.setFilePath(rset.getString("FILE_PATH"));
				mFileOne.setFileSize(rset.getInt("FILE_SIZE"));
				mFileOne.setFileUser(rset.getNString("FILE_USER"));
				mFileOne.setUploadTime(rset.getTimestamp("UPLOAD_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mFileOne;
	}

}

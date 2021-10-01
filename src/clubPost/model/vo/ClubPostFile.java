package clubPost.model.vo;

import java.sql.Date;

public class ClubPostFile {
	private int postNo;
	private int clubNo;
	private String userId;
	private String fileName;
	private String filePath;
	private long fileSize;
	private Date uploadDate;
	
	public ClubPostFile() {}

	public ClubPostFile(int postNo, int clubNo, String userId, String fileName, String filePath, long fileSize,
			Date uploadDate) {
		super();
		this.postNo = postNo;
		this.clubNo = clubNo;
		this.userId = userId;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.uploadDate = uploadDate;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public int getClubNo() {
		return clubNo;
	}

	public void setClubNo(int clubNo) {
		this.clubNo = clubNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Override
	public String toString() {
		return "ClubPostFile [postNo=" + postNo + ", clubNo=" + clubNo + ", userId=" + userId + ", fileName=" + fileName
				+ ", filePath=" + filePath + ", fileSize=" + fileSize + ", uploadDate=" + uploadDate + "]";
	}
	
}

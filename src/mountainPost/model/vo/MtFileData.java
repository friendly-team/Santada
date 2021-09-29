package mountainPost.model.vo;

import java.sql.Timestamp;

public class MtFileData {
	private int mtPostNo;
	private String mtName;
	private String fileName;
	private String filePath;
	private long fileSize;
	private String fileUser;
	private Timestamp uploadTime;
	
	public void MtFileData() {}
	
	public int getMtPostNo() {
		return mtPostNo;
	}
	public void setMtPostNo(int mtPostNo) {
		this.mtPostNo = mtPostNo;
	}
	public String getMtName() {
		return mtName;
	}
	public void setMtName(String mtName) {
		this.mtName = mtName;
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
	public String getFileUser() {
		return fileUser;
	}
	public void setFileUser(String fileUser) {
		this.fileUser = fileUser;
	}
	public Timestamp getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	@Override
	public String toString() {
		return "MtFileData [mtPostNo=" + mtPostNo + ", mtName=" + mtName + ", fileName=" + fileName + ", filePath="
				+ filePath + ", fileSize=" + fileSize + ", fileUser=" + fileUser + ", uploadTime=" + uploadTime + "]";
	}
	
}

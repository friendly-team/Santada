package dm.model.vo;

import java.sql.Date;

public class Dm {

	private int letterNo;
	private String userId;
	private String letterContents;
	private String recipientId;
	private String letterSubject;
	private Date writeDate;
	
	public Dm() {}
	
	public Dm(String recipientId, String userId, String letterSubject, String letterContents) {
		super();
		this.recipientId = recipientId;
		this.userId = userId;
		this.letterSubject = letterSubject;
		this.letterContents = letterContents;
	}

	public int getLetterNo() {
		return letterNo;
	}

	public void setLetterNo(int letterNo) {
		this.letterNo = letterNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLetterContents() {
		return letterContents;
	}

	public void setLetterContents(String letterContents) {
		this.letterContents = letterContents;
	}

	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	public String getLetterSubject() {
		return letterSubject;
	}

	public void setLetterSubject(String letterSubject) {
		this.letterSubject = letterSubject;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "Dm [letterNo=" + letterNo + ", userId=" + userId + ", letterContents=" + letterContents
				+ ", recipientId=" + recipientId + ", letterSubject=" + letterSubject + ", writeDate=" + writeDate
				+ "]";
	}
	
	
}

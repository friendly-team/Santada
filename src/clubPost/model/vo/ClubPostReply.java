package clubPost.model.vo;

import java.sql.Date;

public class ClubPostReply {
	private int replyNo;
	private int postNo;
	private int clubNo;
	private String replyContents;
	private String replyUserId;
	private Date replyDate;
	
	public ClubPostReply() {}

	public ClubPostReply(int replyNo, int postNo, int clubNo, String replyContents, String replyUserId,
			Date replyDate) {
		super();
		this.replyNo = replyNo;
		this.postNo = postNo;
		this.clubNo = clubNo;
		this.replyContents = replyContents;
		this.replyUserId = replyUserId;
		this.replyDate = replyDate;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
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

	public String getReplyContents() {
		return replyContents;
	}

	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}

	public String getReplyUserId() {
		return replyUserId;
	}

	public void setReplyUserId(String replyUserId) {
		this.replyUserId = replyUserId;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	@Override
	public String toString() {
		return "ClubPostReply [replyNo=" + replyNo + ", postNo=" + postNo + ", clubNo=" + clubNo + ", replyContents="
				+ replyContents + ", replyUserId=" + replyUserId + ", replyDate=" + replyDate + "]";
	}
}

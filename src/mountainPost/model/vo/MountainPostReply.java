package mountainPost.model.vo;

import java.sql.Date;

public class MountainPostReply {
	private int ReplyNo;
	private int mountainPostNo;
	private String ReplyContents;
	private String ReplyWriter;
	private Date ReplyDate;
	
	public MountainPostReply() {}

	public int getReplyNo() {
		return ReplyNo;
	}

	public void setReplyNo(int replyNo) {
		ReplyNo = replyNo;
	}

	public int getMountainPostNo() {
		return mountainPostNo;
	}

	public void setMountainPostNo(int mountainPostNo) {
		this.mountainPostNo = mountainPostNo;
	}

	public String getReplyContents() {
		return ReplyContents;
	}

	public void setReplyContents(String replyContents) {
		ReplyContents = replyContents;
	}

	public String getReplyWriter() {
		return ReplyWriter;
	}

	public void setReplyWriter(String replyWriter) {
		ReplyWriter = replyWriter;
	}

	public Date getReplyDate() {
		return ReplyDate;
	}

	public void setReplyDate(Date replyDate) {
		ReplyDate = replyDate;
	}

	@Override
	public String toString() {
		return "MountainPostReply [ReplyNo=" + ReplyNo + ", mountainPostNo=" + mountainPostNo + ", ReplyContents="
				+ ReplyContents + ", ReplyWriter=" + ReplyWriter + ", ReplyDate=" + ReplyDate + "]";
	}

}

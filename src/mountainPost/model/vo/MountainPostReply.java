package mountainPost.model.vo;

import java.sql.Date;

public class MountainPostReply {
	private int replyNo;
	private int mountainPostNo;
	private String replyContents;
	private String replyWriter;
	private Date replyDate;
	
	public MountainPostReply() {}

	public int getReplyNo() {
		return replyNo;
	}


	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}


	public int getMountainPostNo() {
		return mountainPostNo;
	}


	public void setMountainPostNo(int mountainPostNo) {
		this.mountainPostNo = mountainPostNo;
	}


	public String getReplyContents() {
		return replyContents;
	}


	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}


	public String getReplyWriter() {
		return replyWriter;
	}


	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}


	public Date getReplyDate() {
		return replyDate;
	}


	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	@Override
	public String toString() {
		return "MountainPostReply [replyNo=" + replyNo + ", mountainPostNo=" + mountainPostNo + ", replyContents="
				+ replyContents + ", replyWriter=" + replyWriter + ", replyDate=" + replyDate + "]";
	}

}

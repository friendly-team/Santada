package clubPost.model.vo;

import java.sql.Date;
import java.util.List;

public class ClubPost {
	private int postNo;
	private int clubNo;
	private String userId;
	private String postSubject;
	private String postContents;
	private int recommend;
	private Date writeDate;
	private List<ClubPostReply> clubReplies;
	private ClubPostFile clubPostFile;
	
	public ClubPost() {}

	public ClubPost(int postNo, int clubNo, String userId, String postSubject, String postContents, Date writeDate,
			List<ClubPostReply> clubReplies, ClubPostFile clubPostFile, int recommend) {
		super();
		this.postNo = postNo;
		this.clubNo = clubNo;
		this.userId = userId;
		this.postSubject = postSubject;
		this.postContents = postContents;
		this.writeDate = writeDate;
		this.clubReplies = clubReplies;
		this.clubPostFile = clubPostFile;
		this.recommend = recommend;
	}
	
	
	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
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

	public String getPostSubject() {
		return postSubject;
	}

	public void setPostSubject(String postSubject) {
		this.postSubject = postSubject;
	}

	public String getPostContents() {
		return postContents;
	}

	public void setPostContents(String postContents) {
		this.postContents = postContents;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public List<ClubPostReply> getClubReplies() {
		return clubReplies;
	}

	public void setClubReplies(List<ClubPostReply> clubReplies) {
		this.clubReplies = clubReplies;
	}

	public ClubPostFile getClubPostFile() {
		return clubPostFile;
	}

	public void setClubPostFile(ClubPostFile clubPostFile) {
		this.clubPostFile = clubPostFile;
	}

	@Override
	public String toString() {
		return "ClubPost [postNo=" + postNo + ", clubNo=" + clubNo + ", userId=" + userId + ", postSubject="
				+ postSubject + ", postContents=" + postContents + ", recommend=" + recommend + ", writeDate="
				+ writeDate + ", clubReplies=" + clubReplies + ", clubPostFile=" + clubPostFile + "]";
	}

}

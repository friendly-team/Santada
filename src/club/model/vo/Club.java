package club.model.vo;

import java.sql.Date;

public class Club {
	private int clubNo;
	private String userId;
	private String clubName;
	private String clubRegion;
	private int clubAge;
	private String clubIntroduce;
	private Date clubCreateDate;
	public Club() {}

	
	
	public Club(int clubNo, String userId, String clubName, String clubRegion, int clubAge, String clubIntroduce, Date clubCreateDate) {
		super();
		this.clubNo = clubNo;
		this.userId = userId;
		this.clubName = clubName;
		this.clubRegion = clubRegion;
		this.clubAge = clubAge;
		this.clubIntroduce = clubIntroduce;
		this.clubCreateDate = clubCreateDate;
	}



	public Date getClubCreateDate() {
		return clubCreateDate;
	}



	public void setClubCreateDate(Date clubCreateDate) {
		this.clubCreateDate = clubCreateDate;
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

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getClubRegion() {
		return clubRegion;
	}

	public void setClubRegion(String clubRegion) {
		this.clubRegion = clubRegion;
	}

	public int getClubAge() {
		return clubAge;
	}

	public void setClubAge(int clubAge) {
		this.clubAge = clubAge;
	}

	public String getClubIntroduce() {
		return clubIntroduce;
	}

	public void setClubIntroduce(String clubIntroduce) {
		this.clubIntroduce = clubIntroduce;
	}



	@Override
	public String toString() {
		return "Club [clubNo=" + clubNo + ", userId=" + userId + ", clubName=" + clubName + ", clubRegion=" + clubRegion
				+ ", clubAge=" + clubAge + ", clubIntroduce=" + clubIntroduce + "]";
	}
}

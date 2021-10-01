package club.model.vo;

import java.sql.Date;

public class ClubManagement {
	private int clubNo;
	private String userId;
	private String userName;
	private int userAge;
	private int userPosition;
	private Date joinDate;
	private String approvalPosition;
	private String userIntroduce;
	private String joinRoute;
	private String clubName;
	
	public ClubManagement() {}
	
	

	public ClubManagement(int clubNo, String userId, String userName, int userAge, int userPosition, Date joinDate,
			String approvalPosition, String userIntroduce, String joinRoute, String clubName) {
		super();
		this.clubNo = clubNo;
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
		this.userPosition = userPosition;
		this.joinDate = joinDate;
		this.approvalPosition = approvalPosition;
		this.userIntroduce = userIntroduce;
		this.joinRoute = joinRoute;
		this.clubName = clubName;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public int getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(int userPosition) {
		this.userPosition = userPosition;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getApprovalPosition() {
		return approvalPosition;
	}

	public void setApprovalPosition(String approvalPosition) {
		this.approvalPosition = approvalPosition;
	}

	public String getUserIntroduce() {
		return userIntroduce;
	}

	public void setUserIntroduce(String userIntroduce) {
		this.userIntroduce = userIntroduce;
	}

	public String getJoinRoute() {
		return joinRoute;
	}

	public void setJoinRoute(String joinRoute) {
		this.joinRoute = joinRoute;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	@Override
	public String toString() {
		return "ClubManagement [clubNo=" + clubNo + ", userId=" + userId + ", userName=" + userName + ", userAge="
				+ userAge + ", userPosition=" + userPosition + ", joinDate=" + joinDate + ", approvalPosition="
				+ approvalPosition + ", userIntroduce=" + userIntroduce + ", joinRoute=" + joinRoute + ", clubName="
				+ clubName + "]";
	}
	
	

	
	
	
}

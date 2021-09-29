package mountainPost.model.vo;

import java.sql.Date;

public class MountainPost {
	private int mountainPostNo;
	private String mountainName;
	private String mountainPostWriter;
	private String mountainPostSubject;	
	private String mountainPostContents;
	private Date mountainPostDate;
	private String mountainRegion;
	private String mountainCourse;
	private int mountainTime;
	private int mountainParty;
	private int mountainLevel;
	private String mountainCaution;
	private String mountainNeed;
	private int mountainRecommend;
	private String mountainPostState;
	
	public MountainPost() {}
	
	public MountainPost(int mountainPostNo, String mountainName, String mountainPostWriter, String mountainPostSubject,
			String mountainPostContents, Date mountainPostDate, String mountainRegion, String mountainCourse,
			int mountainTime, int mountainParty, int mountainLevel, String mountainCaution, String mountainNeed,
			int mountainRecommend, String mountainPostState) {
		this.mountainPostNo = mountainPostNo;
		this.mountainName = mountainName;
		this.mountainPostWriter = mountainPostWriter;
		this.mountainPostSubject = mountainPostSubject;
		this.mountainPostContents = mountainPostContents;
		this.mountainPostDate = mountainPostDate;
		this.mountainRegion = mountainRegion;
		this.mountainCourse = mountainCourse;
		this.mountainTime = mountainTime;
		this.mountainParty = mountainParty;
		this.mountainLevel = mountainLevel;
		this.mountainCaution = mountainCaution;
		this.mountainNeed = mountainNeed;
		this.mountainRecommend = mountainRecommend;
		this.mountainPostState = mountainPostState;
	}

	public int getMountainPostNo() {
		return mountainPostNo;
	}

	public void setMountainPostNo(int mountainPostNo) {
		this.mountainPostNo = mountainPostNo;
	}

	public String getMountainName() {
		return mountainName;
	}

	public void setMountainName(String mountainName) {
		this.mountainName = mountainName;
	}

	public String getMountainPostWriter() {
		return mountainPostWriter;
	}

	public void setMountainPostWriter(String mountainPostWriter) {
		this.mountainPostWriter = mountainPostWriter;
	}

	public String getMountainPostSubject() {
		return mountainPostSubject;
	}

	public void setMountainPostSubject(String mountainPostSubject) {
		this.mountainPostSubject = mountainPostSubject;
	}

	public String getMountainPostContents() {
		return mountainPostContents;
	}

	public void setMountainPostContents(String mountainPostContents) {
		this.mountainPostContents = mountainPostContents;
	}

	public Date getMountainPostDate() {
		return mountainPostDate;
	}

	public void setMountainPostDate(Date mountainPostDate) {
		this.mountainPostDate = mountainPostDate;
	}

	public String getMountainRegion() {
		return mountainRegion;
	}

	public void setMountainRegion(String mountainRegion) {
		this.mountainRegion = mountainRegion;
	}

	public String getMountainCourse() {
		return mountainCourse;
	}

	public void setMountainCourse(String mountainCourse) {
		this.mountainCourse = mountainCourse;
	}

	public int getMountainTime() {
		return mountainTime;
	}

	public void setMountainTime(int mountainTime) {
		this.mountainTime = mountainTime;
	}

	public int getMountainParty() {
		return mountainParty;
	}

	public void setMountainParty(int mountainParty) {
		this.mountainParty = mountainParty;
	}

	public int getMountainLevel() {
		return mountainLevel;
	}

	public void setMountainLevel(int mountainLevel) {
		this.mountainLevel = mountainLevel;
	}

	public String getMountainCaution() {
		return mountainCaution;
	}

	public void setMountainCaution(String mountainCaution) {
		this.mountainCaution = mountainCaution;
	}

	public String getMountainNeed() {
		return mountainNeed;
	}

	public void setMountainNeed(String mountainNeed) {
		this.mountainNeed = mountainNeed;
	}

	public int getMountainRecommend() {
		return mountainRecommend;
	}

	public void setMountainRecommend(int mountainRecommend) {
		this.mountainRecommend = mountainRecommend;
	}

	public String getMountainPostState() {
		return mountainPostState;
	}

	public void setMountainPostState(String mountainPostState) {
		this.mountainPostState = mountainPostState;
	}

	@Override
	public String toString() {
		return "MountainPost [mountainPostNo=" + mountainPostNo + ", mountainName=" + mountainName
				+ ", mountainPostWriter=" + mountainPostWriter + ", mountainPostSubject=" + mountainPostSubject
				+ ", mountainPostContents=" + mountainPostContents + ", mountainPostDate=" + mountainPostDate
				+ ", mountainRegion=" + mountainRegion + ", mountainCourse=" + mountainCourse + ", mountainTime="
				+ mountainTime + ", mountainParty=" + mountainParty + ", mountainLevel=" + mountainLevel
				+ ", mountainCaution=" + mountainCaution + ", mountainNeed=" + mountainNeed + ", mountainRecommend="
				+ mountainRecommend + ", mountainPostState=" + mountainPostState + "]";
	}
	
}

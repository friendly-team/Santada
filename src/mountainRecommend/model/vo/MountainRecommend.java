package mountainRecommend.model.vo;

public class MountainRecommend {
	
	private int mountainReNo;
	private int mountainPostNo;
	private String mountainName;
	private String mountainRegion;
	private String mountainCourse;
	private int mountainLength;
	private int mountainTime;
	private int mountainParty;
	private int mountainLevel;
	private int parkingLotNo;
	
	public MountainRecommend() {}

	public MountainRecommend(int mountainReNo, int mountainPostNo, String mountainName, String mountainRegion, String mountainCourse,
			int mountainLength, int mountainTime, int mountainParty, int mountainLevel, int parkingLotNo) {
		super();
		
		this.mountainReNo = mountainReNo;
		this.mountainPostNo = mountainPostNo;
		this.mountainName = mountainName;
		this.mountainRegion = mountainRegion;
		this.mountainCourse = mountainCourse;
		this.mountainLength = mountainLength;
		this.mountainTime = mountainTime;
		this.mountainParty = mountainParty;
		this.mountainLevel = mountainLevel;
		this.parkingLotNo = parkingLotNo;
	}

	public int getMountainReNo() {
		return mountainReNo;
	}

	public void setMountainReNo(int mountainReNo) {
		this.mountainReNo = mountainReNo;
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

	public int getMountainLength() {
		return mountainLength;
	}

	public void setMountainLength(int mountainLength) {
		this.mountainLength = mountainLength;
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

	public int getParkingLotNo() {
		return parkingLotNo;
	}

	public void setParkingLotNo(int parkingLotNo) {
		this.parkingLotNo = parkingLotNo;
	}

	@Override
	public String toString() {
		return "MountainRecommend [mountainReNo=" + mountainReNo + ", mountainPostNo=" + mountainPostNo
				+ ", mountainName=" + mountainName + ", mountainRegion=" + mountainRegion + ", mountainCourse="
				+ mountainCourse + ", mountainLength=" + mountainLength + ", mountainTime=" + mountainTime
				+ ", mountainParty=" + mountainParty + ", mountainLevel=" + mountainLevel + ", parkingLotNo="
				+ parkingLotNo + "]";
	}

		
}

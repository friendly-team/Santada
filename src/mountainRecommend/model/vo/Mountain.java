package mountainRecommend.model.vo;

public class Mountain {
	
	private String mountainName;
	private int parkingLotNo;
	private String mountainRegion;
	private String mountainLength;
	private String mountainCourse;
	
	public Mountain() {}

	public Mountain(String mountainName, int parkingLotNo, String mountainRegion, String mountainLength,
			String mountainCourse) {
		super();
		this.mountainName = mountainName;
		this.parkingLotNo = parkingLotNo;
		this.mountainRegion = mountainRegion;
		this.mountainLength = mountainLength;
		this.mountainCourse = mountainCourse;
	}

	public String getMountainName() {
		return mountainName;
	}

	public void setMountainName(String mountainName) {
		this.mountainName = mountainName;
	}

	public int getParkingLotNo() {
		return parkingLotNo;
	}

	public void setParkingLotNo(int parkingLotNo) {
		this.parkingLotNo = parkingLotNo;
	}

	public String getMountainRegion() {
		return mountainRegion;
	}

	public void setMountainRegion(String mountainRegion) {
		this.mountainRegion = mountainRegion;
	}

	public String getMountainLength() {
		return mountainLength;
	}

	public void setMountainLength(String mountainLength) {
		this.mountainLength = mountainLength;
	}

	public String getMountainCourse() {
		return mountainCourse;
	}

	public void setMountainCourse(String mountainCourse) {
		this.mountainCourse = mountainCourse;
	}

	@Override
	public String toString() {
		return "Mountain [mountainName=" + mountainName + ", parkingLotNo=" + parkingLotNo + ", mountainRegion="
				+ mountainRegion + ", mountainLength=" + mountainLength + ", mountainCourse=" + mountainCourse + "]";
	}

	
	
}

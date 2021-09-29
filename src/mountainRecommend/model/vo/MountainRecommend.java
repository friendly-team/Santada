package mountainRecommend.model.vo;

public class MountainRecommend {
	
	private String mountainName;
	private String mountainRegion;
	private String mountainCourse;
	private int mountainLength;
	private int mountainTime;
	private int mountainLevel;
	private String parking;
	
	public MountainRecommend() {}
	
	public MountainRecommend(String mountainName, String mountainRegion, String mountainCourse, int mountainLength,
			int mountainTime, int mountainLevel, String parking) {
		super();
		this.mountainName = mountainName;
		this.mountainRegion = mountainRegion;
		this.mountainCourse = mountainCourse;
		this.mountainLength = mountainLength;
		this.mountainTime = mountainTime;
		this.mountainLevel = mountainLevel;
		this.parking = parking;
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

	public int getMountainLevel() {
		return mountainLevel;
	}

	public void setMountainLevel(int mountainLevel) {
		this.mountainLevel = mountainLevel;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	@Override
	public String toString() {
		return "MountainRecommend [mountainName=" + mountainName + ", mountainRegion=" + mountainRegion
				+ ", mountainCourse=" + mountainCourse + ", mountainLength=" + mountainLength + ", mountainTime="
				+ mountainTime + ", mountainLevel=" + mountainLevel + ", parking=" + parking + "]";
	}
	
		
}

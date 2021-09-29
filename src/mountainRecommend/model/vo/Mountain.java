package mountainRecommend.model.vo;

public class Mountain {
	
	private String mountainName;
	private Number parkinglotNo;
	private String mountainRegeion;
	
	public Mountain() {}

	public Mountain(String mountainName, Number parkinglotNo, String mountainRegeion) {
		super();
		this.mountainName = mountainName;
		this.parkinglotNo = parkinglotNo;
		this.mountainRegeion = mountainRegeion;
	}

	public String getMountainName() {
		return mountainName;
	}

	public void setMountainName(String mountainName) {
		this.mountainName = mountainName;
	}

	public Number getParkinglotNo() {
		return parkinglotNo;
	}

	public void setParkinglotNo(Number parkinglotNo) {
		this.parkinglotNo = parkinglotNo;
	}

	public String getMountainRegeion() {
		return mountainRegeion;
	}

	public void setMountainRegeion(String mountainRegeion) {
		this.mountainRegeion = mountainRegeion;
	}

	@Override
	public String toString() {
		return "Mountain [mountainName=" + mountainName + ", parkinglotNo=" + parkinglotNo + ", mountainRegeion="
				+ mountainRegeion + "]";
	}
	
	

}
